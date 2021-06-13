package main

import (
	"fmt"
	"math"
	"strconv"
)



func main() {
	n := int32(439)

	str := strconv.FormatInt(int64(n),2)

	var max,cnt int
	for _,ch := range str {
		if ch == '0'{
			max = int(math.Max(float64(cnt), float64(max)))
			cnt = 0
		}else {
			cnt++
		}
	}
	max = int(math.Max(float64(cnt), float64(max)))
	fmt.Println(max)
}

