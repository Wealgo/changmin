package main

func sum(a []int) int {
	var r int
    for i := 0; i < len(a); i++ {
        r += a[i]
     }
	return r
}
