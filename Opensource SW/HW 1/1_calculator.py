# 정수 입력 두개

num1 = input("1. 1번째 n자리 정수 출력\nn자리 정수를 입력하세요: ")
num2 = input("2. 2번째 n자리 정수 출력\nn자리 정수를 입력하세요: ")

print("3. 곱셈 결과 출력")
max_length = max(len(num1), len(num2))

# 계산기 상단부 출력
if max_length == len(num1):
    print("  ", num1)
else:
    space = max_length - len(num1)
    while space:
        space -= 1
        print(" ", end="")
    print("  ", num1)

if max_length == len(num2):
    print("x ", num2)
else:
    space = max_length - len(num2)
    print("X", end="")
    while space:
        space -= 1
        print(" ", end="")
    print(" ", num2)

for i in range(max_length+2):
    print("-", end="")
print("-")

# 계산을 위해 수로 변환
num1 = int(num1)
num2 = int(num2)
res = num1 * num2
num1 = abs(num1)
num2 = abs(num2)

turn = 0
for i in range(len(str(num2))):
    now = (num2%10) * num1
    t = max_length - len(str(now)) + 3 - turn
    turn += 1
    for i in range(t):
        print(" ", end="")
    print(now, end="")

    print("")

    num2 = int(num2/10)

for i in range(max_length + 2):
    print("-", end="")
print("-")

if len(str(res)) > max_length+2:
    print(res)
else:
    for i in range(max_length+2-len(str(res)) + 1):
        print(" ", end="")
    print(res)


