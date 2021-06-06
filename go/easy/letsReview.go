package main
import (
	"fmt"
	"strings"
)

func main() {
	//Enter your code here. Read input from STDIN. Print output to STDOUT
	var N int
	fmt.Scan(&N)
	var str string

	for i:=0; i < N; i++{
		fmt.Scan(&str)

		even := make([]string,len(str)/2)
		odd := make([]string,len(str)/2)

		for j:=0; j < len(str); j++ {
			if(j % 2 == 0){
				even = append(even,str[j:j+1])
			}else{
				odd = append(odd,str[j:j+1])
			}
		}
		fmt.Println(strings.Join(even,"") + " " + strings.Join(odd,""))

	}
}