class Menu:
    def __init__(self):
        self.f = open("cafe.txt", 'r')
        self.orderList = {}
        self.total = int(0)
        self.size = 0

    def addMenu(self, f):
        self.f = f
        while True:
            line = f.readline().rstrip('\n')
            e = line.split(', ')
            if not line: break
            self.orderList[int(e[0])-1] = e
            self.size += 1
        f.close()

    def printMenu(self):
        print("===============================")
        for i in range(len(self.orderList)):
            num = self.orderList[i][0]
            name = self.orderList[i][1]
            price = self.orderList[i][2]
            stock = self.orderList[i][3]
            print(num, ".", name, "\t", "금액: ", price, "원 재고: ", stock, sep="")
        print("end를 입력하시면 주문서로 돌아갑니다.")
        print("===============================")


class Order:
    def __init__(self):
        self.nowOrder = int(0)
        self.nowPrice = int(0)
        self.orderResult = []
        for i in range(Mnu.size):
            self.orderResult.append(0)

    def endOrder(self):
        Mnu.printMenu()
        for i in range(Mnu.size):
            self.nowOrder += int(self.orderResult[i])
            self.nowPrice += int(self.orderResult[i])*int(Mnu.orderList[i][2])
        print("주문내역")
        print("총 주문 수량: ", self.nowOrder, "개, 총 주문 금액: ", self.nowPrice, "원", sep="")

    def orderMenu(self, menuNum):
        while True:
            if menuNum == 'end':
                self.endOrder()
                return
            else:
                while int(Mnu.size) < int(menuNum):
                    print("존재하지 않는 메뉴입니다.\n메뉴 번호를 다시 입력해주세요")
                    menuNum = input("input: ")
                    if menuNum == 'end':
                        self.endOrder()
                        return

            print("주문할 메뉴의 수량을 입력해주세요")
            n = input("input: ")

            if n == 'end' or menuNum == 'end':
                self.endOrder()
                break
            else:
                n = int(n)
                menuNum = int(menuNum)
                now_stock = int(Mnu.orderList[menuNum - 1][3])
                if now_stock == 0:
                    print("품절되었습니다. 다른 메뉴를 선택해주세요")
                    menuNum = input("메뉴 번호를 다시 입력해주세요\ninput: ")
                elif now_stock < n:
                    print("수량이 부족합니다")
                    Mnu.printMenu()
                else:
                    Mnu.orderList[menuNum - 1][3] = now_stock - n
                    Mnu.total = int(Mnu.total) + int(Mnu.orderList[menuNum - 1][2]) * n
                    Odr.orderResult[menuNum - 1] += n

                    menuNum = input("추가로 주문할 메뉴 번호를 입력해주세요\ninput: ")
                    if menuNum == 'end':
                        self.endOrder()
                        return
                    else: Mnu.printMenu()


class Manage:
    def __init__(self):
        self.nowOrder = int(0)
        self.nowPrice = int(0)
        self.ManageResult = []
        for i in range(Mnu.size):
            self.ManageResult.append(0)

    def totSale(self):
        print("총 매출은 ", Mnu.total, "원 입니다.", sep="")

    def endOrder(self):
        Mnu.printMenu()
        for i in range(Mnu.size):
            self.nowOrder += int(self.ManageResult[i])
            self.nowPrice += int(self.ManageResult[i]) * int(Mnu.orderList[i][2])
        print("주문내역")
        print("총 주문 수량: ", self.nowOrder, "개, 총 주문 금액: ", self.nowPrice, "원", sep="")

    def Management(self, menuNum):
        while True:
            if menuNum == 'end':
                self.endOrder()
                return
            else:
                while int(Mnu.size) < int(menuNum):
                    print("존재하지 않는 메뉴입니다.\n메뉴 번호를 다시 입력해주세요")
                    menuNum = input("input: ")
                    if menuNum == 'end':
                        self.endOrder()
                        return

            print("선택한 메뉴의 수량을 입력해주세요")
            n = input("input: ")

            if n == 'end' or menuNum == 'end':
                self.endOrder()
                break
            else:
                n = int(n)
                menuNum = int(menuNum)
                now_stock = int(Mnu.orderList[menuNum - 1][3])

                Mnu.orderList[menuNum - 1][3] = now_stock + n
                Mge.ManageResult[menuNum - 1] += n

                menuNum = input("추가로 주문할 메뉴 번호를 입력해주세요\ninput: ")
                if menuNum == 'end':
                    self.endOrder()
                    return
                else: Mnu.printMenu()



# main
file = open("cafe.txt", 'r')
Mnu = Menu()
Mnu.addMenu(file)

while True:
    print("=============")
    print("\t주문서\t")
    print("=============")
    print("1. 커피 주문하기")
    print("2. 커피 매출 확인")
    print("3. 커피 입고 하기")
    print("4. 종료하기")
    print("====================")
    print("원하시는 주문 번호를 입력해주세요")
    order_num = input("input: ")

    if order_num == '1':
        Odr = Order()
        print("주문할 메뉴 번호를 입력해주세요")
        menu_num = input("input: ")
        if menu_num == 'end':
            Odr.endOrder()
        else:
            menu_num = int(menu_num)
            Mnu.printMenu()
            Odr.orderMenu(menu_num)

    elif order_num == '2':
        Mge = Manage()
        Mge.totSale()
    elif order_num == '3':
        Mge = Manage()
        print("입고할 메뉴 번호를 입력해주세요")
        menu_num = input("input: ")
        if menu_num == 'end':
            Mge.endOrder()
        else:
            menu_num = int(menu_num)
            Mnu.printMenu()
            Mge.Management(menu_num)

    elif order_num == '4':
        break
