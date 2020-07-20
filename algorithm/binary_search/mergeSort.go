package main

import "fmt"

func main() {
	arr := []int{3, 4, 5, 1, 2, 4, 6, 2, 3}
	fmt.Printf("%v", merge(arr))
}

func merge(arr []int) []int {
	if len(arr) < 2 {
		return arr
	}

	// be careful left = []int(arr(0:len(arr)/2), because this func will change
	// the reference, not the value, once `arr` value change, `left` value
	// will also get changed.
	// if really want to use this func, then have to use
	// `arr = make([]int, len(arr))` to remove the reference in arr

	// instead of using this confuse value set, I choose to create a new left
	// and right
	left := make([]int, len(arr)/2)
	right := make([]int, len(arr)-len(arr)/2)
	_ = copy(left, arr[0:len(arr)/2])
	_ = copy(right, arr[len(arr)/2:])
	left = merge(left)
	right = merge(right)
	r, l := 0, 0

	for cur := 0; cur < len(arr); cur++ {
		if l >= len(left) {
			arr[cur] = right[r]
			r++
		} else if r >= len(right) {
			arr[cur] = left[l]
			l++
		} else if left[l] < right[r] {
			arr[cur] = left[l]
			l++
		} else {
			arr[cur] = right[r]
			r++
		}
	}
	fmt.Println(arr)
	return arr
}
