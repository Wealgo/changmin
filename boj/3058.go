package main

import (
	"fmt"
)

func main() {
	var testcase int
	fmt.Scan(&testcase)
	for i := 0; i < testcase; i++ {
		slice := make([]int, 7)
		for j := 0; j < 7; j++ {
			var data int
			fmt.Scan(&data)
			slice[j] = data
		}
		var evnSlice []int
		for j := 0; j < 7; j++ {
			if slice[j]%2 == 0 {
				evnSlice = append(evnSlice, slice[j])
			}
		}
		var sum int
		min := 100
		for j := 0; j < len(evnSlice); j++ {
			sum = sum + evnSlice[j]
		}
		for j := 0; j < len(evnSlice); j++ {
			if min > evnSlice[j] {
				min = evnSlice[j]
			}
		}
		fmt.Println(sum, min)
	}
}
