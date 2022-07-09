package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var (
	n, m  int
	board [][]string
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	input := scanner.Text()
	tmp := strings.Split(input, " ")
	n, _ = strconv.Atoi(tmp[0])
	m, _ = strconv.Atoi(tmp[1])

	tmpBoard := make([][]string, n)
	for i := 0; i < n; i++ {
		tmpBoard[i] = make([]string, m)
	}

	for i := 0; i < n; i++ {
		scanner.Scan()
		tmpBoard[i] = strings.Split(scanner.Text(), "")
	}

	board = tmpBoard
	minimum := 9999
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			minimum = min(StartWithBlack(i, j), minimum)
			minimum = min(StartWithWhite(i, j), minimum)
		}
	}
	fmt.Println(minimum)
}

func StartWithWhite(ni int, nj int) int {
	if ni+8 > n || nj+8 > m {
		return 9999
	}
	output := 0
	for i := ni; i < ni+8; i++ {
		if i%2 == 0 {
			output += rawStartWithWhite(board[i][nj : nj+8])
		} else {
			output += rawStartWithBlack(board[i][nj : nj+8])
		}
	}
	return output
}

func StartWithBlack(ni int, nj int) int {
	if ni+8 > n || nj+8 > m {
		return 9999
	}
	output := 0
	for i := ni; i < ni+8; i++ {
		if i%2 == 0 {
			output += rawStartWithBlack(board[i][nj : nj+8])
		} else {
			output += rawStartWithWhite(board[i][nj : nj+8])
		}
	}
	return output
}

func rawStartWithBlack(input []string) int {
	output := 0
	standard := []string{"B", "W", "B", "W", "B", "W", "B", "W"}
	for i, s := range standard {
		if input[i] != s {
			output++
		}
	}
	return output
}

func rawStartWithWhite(input []string) int {
	output := 0
	standard := []string{"W", "B", "W", "B", "W", "B", "W", "B"}
	for i, s := range standard {
		if input[i] != s {
			output++
		}
	}
	return output
}

func min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}
