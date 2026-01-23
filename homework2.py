#input: Name,Price,Quantity
while True:
    name = (input("Enter Name or type exit: ")).strip()
    if name.lower() == "exit":
        print("Goodbye! ")
        break
    price = int(input("Enter Price(VND): "))
    quantity = int(input("Enter Quantity: "))
    
    
    #process: Calculate sale rate
    if(quantity<10):
        print("Sale: ",0)
        sale = 0
    elif(quantity>=10 and quantity <=20):
        print(f"Sale:{5}%")
        sale = 0.05
    elif(quantity >= 21 and quantity <= 50):
        print(f"Sale:{10}%")
        sale = 0.1
    elif(quantity>50):
        print(f"Sale:{15}%")
        sale = 0.15
    totalprice = (price*quantity) * (1-sale)
    #output: Print Name, Price, Quantity, Total price, Sale
    print(f"Sale: {sale*100}%")
    print(f"Total price: {totalprice}")
    