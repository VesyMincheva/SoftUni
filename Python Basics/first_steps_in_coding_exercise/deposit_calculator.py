amount = float(input())
months = int(input())
annual_percentage_rate = float(input())

total_sum = amount + months * ((amount * annual_percentage_rate / 100) / 12)
print(total_sum)