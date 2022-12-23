.class public Test
.super java/lang/Object


.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static fib(I)I
.limit stack 32
.limit locals 32
iload_0 
ldc 0 
isub 
ifle label1
ldc 0
goto label2
label1: 
ldc 1
label2: 

ifeq label14
ldc 0 

goto label0

goto label13
label14: 
iload_0 
ldc 1 
isub 
ifeq label3
ldc 0
goto label4
label3: 
ldc 1
label4: 

ifeq label12
ldc 1 

goto label0

goto label11
label12: 

iload_0 
ldc 1 
isub 
invokestatic Test/fib(I)I

iload_0 
ldc 2 
isub 
invokestatic Test/fib(I)I
iadd 

goto label0

label11:

label13:
label0:
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32

ldc 11 
invokestatic Test/fib(I)I
istore_1 
getstatic java/lang/System/out Ljava/io/PrintStream; 

iload_1 
invokevirtual java/io/PrintStream/println(I)V
label0:
return
.end method

