#input: name,kpi
while True:
    name = (input("Enter name or enter exit: ")).strip()
    if name.lower() =="exit":
        print("Goodbye! ")
        break
    kpi = int(input("Enter KPI: "))
    if kpi<10000000:
       commission = 0
    elif kpi >= 10000000 and kpi <=  30000000:
        commission = 0.05
    elif kpi >= 30000000 and kpi <= 50000000:
        commission = 0.1
    elif kpi > 50000000:
        commission = 0.15
    salary = kpi * commission
    print("Name: ", name)
    print("Kpi: ",kpi)
    print("Comission rate : ",commission)
    print("Comission: ",salary)
    
    