package main

import (
	"fmt"
)



func main() {
	arr := [][]int32{{-1, -1, 0, -9, -2, -2},
		{-2, -1, -6, -8 ,-2, -5},
		{-1, -1, -1, -2, -3, -4},
		{-1, -9, -2, -4, -4, -5},
		{-7, -3, -3, -2, -9, -9},
		{-1, -3, -1, -2, -4, -5},
	}

	fmt.Println(-6 > -20)
	var max,cnt int32 = -55, 0
	for i:=0; i < 4; i++{
		for j:=0; j < 4; j++{
			cnt = 0
			cnt += arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j]+ arr[i+2][j+1] + arr[i+2][j+2]

			if cnt > max {
				max = cnt
			}
		}
	}
	fmt.Println(max)

}
