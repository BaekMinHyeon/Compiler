func fib(i int) int {
    if (i <= 0) {
        return 0
    } else if (i == 1) {
        return 1
    } else {
        return fib(i - 1) + fib(i - 2)
    }
}

func main() {
    var result
    result = fib(11)
    _print(result)
}