.class public Sum

.super java/lang/Object
.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

;sum function
.method public static sum(I)I
.limit stack 32
.limit locals 8
iconst_0
istore_1
ldc 1
istore_2

;write your code

Loop:
iload_2
iload_0
if_icmpgt Lend
iload_2
iload_1
iadd
istore_1
iinc 2 +1
goto Loop

Lend:
iload_1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 8
ldc 100
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokestatic Sum/sum(I)I
invokevirtual java/io/PrintStream/println(I)V
return
.end method