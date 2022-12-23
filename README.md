# Compiler
CNU_compiler_homework

Hul_make_C : .hul을 .c로 바꾸어 파일에 출력

1. 조건
- Hul? standard input으로 정수를 읽어서 변수에 저장한다.
- Hul! standard output으로 변수를 출력한다.
- Hul> 변수의 값을 1증가시킨다. 
- Hul< 변수의 값을 1감소시킨다.
- Hul{ <명령들> } <반복 횟수>  <명령들>을 <반복 횟수>번 수행한다

2. 가정
- 변수는 정수 변수 _hul 하나뿐이다.
- 모든 토큰은 빈칸으로 구분된다.
- block 중첩 깊이는 10이하이다.

Mini_Go : antlr를 이용하여 간단한 문법에 대해 아래와 같이 매치된 규칙번호와 구성하는 규칙번호가 학번과 함께 출력되도록 구문분석기를 구현

1. 방법
program : decl+ {System.out.println("202100000 Rule 0");};
decl : var_decl {System.out.println("202100000 Rule 1-1");}
| fun_decl {System.out.println("202100000 Rule 1-2");};
var_decl : type_spec IDENT ';' {System.out.println("202100000 Rule 2-1");}
| type_spec IDENT '[' ']' ';' {System.out.println("202100000 Rule 2-2");};
...

