package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	s, w := bufio.NewScanner(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()

	var n int
	var list [10001]int
	s.Scan()
	N, _ := strconv.Atoi(s.Text())

	for ; 0 < N; N-- {
		s.Scan()
		n, _ = strconv.Atoi(s.Text())
		list[n]++
	}
	for k, v := range list {
		if 0 < v {
			fmt.Fprint(w, strings.Repeat(fmt.Sprintf("%d\n", k), v))
		}
	}
}
