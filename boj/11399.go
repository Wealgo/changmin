package main

import (
	"fmt"
	"sort"
)

var n int

func main() {
	fmt.Scan(&n)
	slice := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&slice[i])
	}

	sort.Slice(slice, func(i, j int) bool {
		return slice[i] < slice[j]
	})
	var output int
	output = slice[0]
	nslice := make([]int, n)
	nslice[0] = slice[0]
	for i := 1; i < n; i++ {
		nslice[i] = slice[i] + nslice[i-1]
		output = output + nslice[i]
	}
	fmt.Println(output)
}
