package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	var _ = strconv.Itoa // Ignore this comment. You can still use the package "strconv".

	var i uint64 = 4
	var d float64 = 4.0
	var s string = "HackerRank "

	scanner := bufio.NewScanner(os.Stdin)

	var i1 uint64
	var i2 float64
	var i3 string

	fmt.Scanf("%d",&i1)
	fmt.Scanf("%f",&i2)
	for scanner.Scan(){
		i3 += scanner.Text()
	}

	fmt.Println(i1 + i)
	fmt.Println(uint8(i2 + d))
	fmt.Println( s+ i3 )

}