import random
import time


tam = 100_000
arreglo = []
for i in range(tam):
    numero = random.randint(0,99999)
    arreglo.append(numero)
        
inicio = time.perf_counter()
arreglo.sort()
fin = time.perf_counter()

print(f"Tiempo de ordenación: {fin - inicio:.6f} segundos")
