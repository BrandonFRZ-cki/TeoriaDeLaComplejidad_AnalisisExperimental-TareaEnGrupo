import random
import time

class App:
    def __init__(self):
        tam = 100000
        self.arregloBurbuja = self.generar_datos(tam)
        self.arregloSeleccion = self.arregloBurbuja.copy()

    def ejecutar_benchmark(self):
        metodos = { # Diccionario
            "burbuja": self.ordenar_burbuja,
            "seleccion": self.ordenar_seleccion,
        }

        for nombre, metodo in metodos.items():
            tiempo = self.medir_tiempo(metodo, self.arregloBurbuja.copy())
            print(f"Tamaño: {len(self.arregloBurbuja)}, Método: {nombre}, Tiempo: {tiempo:.6f} segundos")

    def generar_datos(self, tam):
        array = []
        for i in range(tam):
            numero = random.randint(0,99999)
            array.append(numero)
        return array

    def medir_tiempo(self, tarea, arr):
        inicio = time.perf_counter()
        tarea(arr)
        fin = time.perf_counter()
        return fin - inicio

    def ordenar_burbuja(self, arreglo):
        n = len(arreglo)
        for i in range(n):
            for j in range(i + 1, n):
                if arreglo[i] > arreglo[j]:
                    arreglo[i], arreglo[j] = arreglo[j], arreglo[i]

    def ordenar_seleccion(self, arreglo):
        n = len(arreglo)
        for i in range(n):
            minIndex = i
            for j in range(i + 1, n):
                if arreglo[j] < arreglo[minIndex]:
                    minIndex = j
            if minIndex != i:
                arreglo[i], arreglo[minIndex] = arreglo[minIndex], arreglo[i]

if __name__ == "__main__":
    app = App()
    app.ejecutar_benchmark()

