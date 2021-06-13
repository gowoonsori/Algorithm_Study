package main
import (
	"fmt"
	"bufio"
	"os"
)

func main() {
	//Enter your code here. Read input from STDIN. Print output to STDOUT
	var n,v int
	var s string
	fmt.Scan(&n)

	m := make(map[string]int)

	for i:= 0; i < n; i++ {
		fmt.Scan(&s)
		fmt.Scan(&v)
		m[s] = v
	}

	sc := bufio.NewScanner(os.Stdin)
	for sc.Scan() {
		s = sc.Text()
		if v, exist := m[s]; exist{
			fmt.Printf("%s=%d\n", s, v)
		} else {
			fmt.Println("Not found")
		}
	}
}
