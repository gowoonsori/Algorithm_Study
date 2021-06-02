package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	//Enter your code here. Read input from STDIN. Print output to STDOUT
	var message string
	hello := "Hello, World."
	in := bufio.NewReader(os.Stdin)

	message, err := in.ReadString('\n')
	if err != nil {
	}
	fmt.Println(hello+"\n"+message)
}