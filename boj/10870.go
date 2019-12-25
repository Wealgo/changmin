package main

import (
	"fmt"
)

/**
 * 재귀로 피보나치 풀기
 * @author quadcore
 *
 */
func main() {
	var n int
	//입력받고
	fmt.Scan(&n)
	//피보나치 가즈아~
	output := fibo(n)
	fmt.Println(output)
}

//재귀
func fibo(n int) int {
	if n == 0 {
		return 0
	}
	if n == 1 {
		return 1
	}
	return fibo(n-1) + fibo(n-2)
}
