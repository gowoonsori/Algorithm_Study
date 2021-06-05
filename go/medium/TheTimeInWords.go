package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)
/*
 * Complete the 'timeInWords' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER h
 *  2. INTEGER m
 */

func timeInWords(h int32, m int32) string {
	// Write your code here
	var str string

	if m == 0 {
		return numberToWord(h) + "o' clock"
	}else if m > 30 {
		h++
		m = 60-m
		str = " to "
	}else{
		str = " past "
	}
	return minuteInWords(m)+ str + numberToWord(h)

}

func minuteInWords(m int32) string {
	//special case
	if m ==0{
		return "zero"
	}else if m == 30 {
		return "half"
	}else if m % 15 ==0 {
		return "quarter"
	}

	var str string
	if m / 10 == 0 {
		str = numberToWord(m)
	}else if m /10 == 1{
		switch m{
		case 13: str = "thirteen "
		default: str = numberToWord(m)+"teen "
		}
	}else{
		str = "twenty " + numberToWord(m%20)
	}

	//return
	if str == "one "{
		return str + "minute"
	}
	return str + "minutes"
}

func numberToWord(m int32) string{
	switch m {
	case 1: return "one "
	case 2: return "two "
	case 3: return "three "
	case 4: return "four "
	case 5: return "five "
	case 6: return "six "
	case 7: return "seven "
	case 8: return "eight "
	case 9: return "nine "
	case 10: return "ten"
	case 11: return "eleven"
	case 12: return "twelve"
	default: return ""
	}
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16 * 1024 * 1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16 * 1024 * 1024)

	hTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	h := int32(hTemp)

	mTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	m := int32(mTemp)

	result := timeInWords(h, m)

	fmt.Fprintf(writer, "%s\n", result)

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
