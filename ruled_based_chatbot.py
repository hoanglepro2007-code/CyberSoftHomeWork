s1 = input().strip() # User enter Hi/Hello
s2 = s1.lower() # Lowercase the string to simplify the if-else behind
if s2 == "hi" or s2 == "hello":
        print("Hi! How can i help you ?\n")

while True:
   
    print("1.Purchasing Advice\n")
    print("2.Lookup Warranty\n")
    print("3.Technical Support\n")
    print("Type Exit!")
    s3 = input().strip() # User choose the funtion
    if s3.lower() == "exit":
        print("Thank you for choosing our chatbot!")
        break
    elif s3 == "1":
        print("Which product would you like to purchase?")
        print("1.Laptop")
        print("2.Phone")
        print("3.Tablet")
        print("Type Exit!")
        s4 = input().strip()
        if s4.lower() == "1":
            print("You choose laptop!")
        elif s4.lower() == "2":
            print("You choose phone!")
        elif s4.lower() == "3":
            print("You choose tablet!")
        elif s4.lower() == "exit":
            print("Return to Main menu!")
            
        
    elif s3.lower() == "2":
        print("Which warranty information would you like to inquire about?")
        print("1.Phone Number")
        print("2.Serial Number")
        print("Type Exit!")
        s4 = input().strip()
        if s4.lower() == "1":
            print("You choose check warranty by phone number!")
        elif s4.lower() =="2":
            print("You choose check warranty by seri numner!")
        elif s4.lower() == "exit":
            print("Return to Main menu!")
            
    elif s3.lower() == "3":
        print("Do you want to choose installation or repair?")
        print("1.Install")
        print("2.Repair")
        print("Type Exit!")
        s4 = input().strip()
        if s4.lower() == "1":
            print("You choosed Install!")
        elif s4.lower() == "2":
            print("You choosed Repair!")
        elif s4.lower() == "exit":
            print("Return to Main menu!")
            
    