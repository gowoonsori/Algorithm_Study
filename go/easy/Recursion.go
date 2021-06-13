package main

import (
	"fmt"
)

/*
 * Complete the 'factorial' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.
 */

func factorial(n int32) int32 {
	// Write your code here
	if n == 1{
		return 1
	}
	return n * factorial(n-1)
}

func main() {
	result := factorial(3)
	fmt.Printf("%d\n", result)
}

