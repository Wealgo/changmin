/**
 * 그리디문제.
 * 인출시간이 가장 적은 사람부터 처리하면 최적해가 나온다.
 * @author quadcore
 *
 */
package main

import (
	"fmt"
	"sort"
)

var n int

func main() {
	fmt.Scan(&n)
	slice := make([]int, n)
	//입력받자
	for i := 0; i < n; i++ {
		fmt.Scan(&slice[i])
	}
	//정렬
	sort.Slice(slice, func(i, j int) bool {
		return slice[i] < slice[j]
	})
	var output int
	//가장 작은 값을 넣어주고
	output = slice[0]
	nslice := make([]int, n)
	//새로운 슬라이스에도 가장 작은값 넣어주고
	nslice[0] = slice[0]
	//정렬된 순서대로 돈을 인출해주자
	for i := 1; i < n; i++ {
		nslice[i] = slice[i] + nslice[i-1]
		output = output + nslice[i]
	}
	fmt.Println(output)
}
