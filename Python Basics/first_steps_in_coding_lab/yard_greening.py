square_meters_yard = float(input())
price_per_square_meter = 7.61
total_price = square_meters_yard * price_per_square_meter
discount = total_price * 0.18
total_price_after_discount = total_price - discount

print(f"The final price is: {total_price_after_discount} lv.")
print(f"The discount is: {discount} lv.")
