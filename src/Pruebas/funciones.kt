package Pruebas

import kotlin.math.sqrt
import kotlin.random.Random

//MANEJO DE FUNCIONES

fun cuadradoNumero(): Unit{

    print("Ingresar numero: ")
    val num: Int = readLine()!!.toInt()

    println("El cuadrado del numero es: ${num*num}")

}//FIN cuadradoNumero()

fun productoNumeros(): Unit{

    print("Ingresar primer numero: ")
    val num1: Int = readLine()!!.toInt()

    print("Ingresar segundo numero: ")
    val num2: Int = readLine()!!.toInt()

    println("El producto de los numeros es: ${num1*num2}")

}//FIN productoNumeros()

fun mayorNumero(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2

fun superficieRectanulo(lado1: Int,lado2: Int): Int = lado1*lado2

fun convertirNumero(num: Int): String = when(num){
                                    1 -> "Uno"
                                    2 -> "Dos"
                                    else -> "Solo 1 y 2"
                                }
fun numeroCaracteres(str: String): Int = str.length

fun alturaPersonas(){

    val arreglo = FloatArray(5)
    var suma: Float = 0f
    var contador: Int = 0

    for (i in arreglo.indices){
        arreglo[i] = Random.nextInt(50,100) + Random.nextFloat()
        suma += arreglo[i]
    }

    for((indice,elemento) in arreglo.withIndex()) println("La altura $elemento se encuentre en el indice $indice")

    val prom: Float = suma/5

    for(i in arreglo.indices){
        if(arreglo[i] > prom) contador++
    }

    println("La cantidad de alturas mayores al promedio $prom es/son: $contador")

}//FIN alturaPersonas()

//MANEJO DE CLASES

data class Idiomas(var idioma: String, var sigla: String)

enum class Constantes(val str: String){
    CONSTANTE1("cte1"),
    CONSTANTE2("cte2")
}

//********
class Cliente (var nombre: String, var monto: Float){

    fun depositarPlata(monto: Float){
        this.monto += monto
    }

    fun extraerPlata(monto: Float){
        this.monto -= monto
    }

    fun imprimirMonto(){
        println("El monto del cliente $nombre es: $monto")
    }
}

class Banco{
    private var cliente1 = Cliente("Pedro",100f)
    private var cliente2 = Cliente("Cole",1000f)
    private var cliente3 = Cliente("Juanita",500f)

    fun depositoTotal(){
        cliente1.depositarPlata(50f)
        cliente2.depositarPlata(150f)
        cliente3.depositarPlata(250f)
    }

    fun extraccionTotal(){
        cliente1.extraerPlata(20f)
        cliente2.extraerPlata(50f)
        cliente3.extraerPlata(15f)
    }

    fun montoTotalClientes(){
        cliente1.imprimirMonto()
        cliente2.imprimirMonto()
        cliente3.imprimirMonto()
    }
}
//********

//MANEJO DE OBJETOS

object Dados{

    val valoresDados = IntArray(5)

    fun almacenarValores(){
        for(indice in valoresDados.indices) valoresDados[indice] = Random.nextInt(1,7)
    }

    fun mostrarValores(){
        for((indice,elemento) in valoresDados.withIndex()) println("El numero del dado ${indice+1} es: $elemento")
    }

    fun mayorValor(): Int{

        val largo = valoresDados.size
        var indice: Int = 0
        var mayor: Int = 0

        while(indice != largo){
            when{
                mayor > valoresDados[indice] -> mayor = mayor
                mayor < valoresDados[indice] -> mayor = valoresDados[indice]
                else -> mayor = mayor
            }

            indice++
        }

        return mayor
    }
}//FIN objeto

//MANEJO DE HERENCIAS

open class Calculadora(val num1: Double, val num2: Double){

    open var resultado: Double = 0.0

    fun suma(){
        resultado = num1 + num2
    }
    fun resta(){
        resultado = num1 - num2
    }
    fun multiplicar(){
        resultado = num1 * num2
    }
    fun dividir(){
        resultado = num1 / num2
    }
    fun imprimir(): Unit = println("El resultado es: $resultado")
}

class CalculadoraCientifica(num1: Double,num2: Double): Calculadora(num1,num2){
    fun cuadradoNum1(){
        resultado = num1*num1
    }
    fun raizNum1(){
        resultado = sqrt(num1)
    }
}

abstract class Cuenta(val titular: String, val monto: Double) {
    open fun imprimir() {
        println("Titular: $titular")
        println("Monto: $monto")
    }
}

class CajaAhorro(titular: String, monto: Double): Cuenta(titular, monto) {
    override fun imprimir() {
        println("Cuenta de caja de ahorro")
        super.imprimir()
    }
}

class PlazoFijo(titular: String, monto: Double, val plazo: Int, val interes: Double): Cuenta(titular, monto) {
    override fun imprimir() {
        println("Cuenta de plazo fijo")
        println("Plazo en dias: $plazo")
        println("Intereses: $interes")
        val ganancia =  monto * interes / 100
        println("Importe del interes: $ganancia")
        super.imprimir()
    }
}

//MANEJO DE FUNCIONES LAMBDA
fun imprimirSi(arreglo: IntArray, fn:(Int) -> Boolean) {
    for(elemento in arreglo)
        if (fn(elemento))
            print("$elemento ")
    println()
}
//fun pruebas () {
//*********************************************************************************
//SUMA - MULT - INTERPOLACION - VALORES PERMUTABLES E INMUTABLES - RESTRINGUIR TIPOS
//*********************************************************************************

//    val num1: Int = 10
//    val num2: Int = 15
//    var sum: Int = num1 + num2
//    print("Suma: $sum ")
//    var mul: Int = num1 * num2
//    print("Multiplicacion: $mul ")
//
//    val peso1: Float = 50.5f
//    val peso2: Float = 80.2f
//    val peso3: Float = 75.25f
//    var prom: Float = (peso1+peso2+peso3)/3
//    print("Promedio: $prom")

//*********************************************************************************
//PEDIR VALROES POR CONSOLA
//*********************************************************************************

//    print("Primer valor")
//    val valor1 = readLine()!!.toInt()
//    print("Segundo valor valor")
//    val valor2 = readLine()!!.toInt()
//    print ("$valor1 y $valor2")

//*********************************************************************************
//CONDICIONALES IF Y ELSE
//*********************************************************************************

//    print("Ingresar primer valor: ")
//    val valor1 = readLine()!!.toInt()
//    print("Ingresar segundo valor: ")
//    val valor2 = readLine()!!.toInt()

//    if (valor1 > valor2)print("El $valor1 es mayor que el $valor2")
//    else print("El $valor2 es mayor que el $valor1")

//    if (valor2>valor1){
//        var sum: Int = valor1 + valor2
//        var res: Int = valor1 - valor2
//        print("Suma: $sum y Resta: $res")
//    }else{
//        var mul: Int = valor1 * valor2
//        var div: Float = valor1.toFloat()/valor2.toFloat()
//        print("Mult: $mul y Div: $div")
//    }

//    var nuevo_valor: Int =
//        if (valor1 % 2 == 0) {
//            print("El numero es par y su cuadrado es: ${valor1*valor1}")
//            valor1*valor1
//        }else{
//            print("El numero es impar y su cubo es: ${valor1*valor1*valor1}")
//            valor1*valor1*valor1
//        }
//
//    print(" Nuevo valor es : $nuevo_valor")

//*********************************************************************************
//ESTRUCTURAS DE REPITICION WHILE - FOR - WHEN - DO WHILE
//*********************************************************************************

//    var num: Int = 1
//    while(num <= 100){
//        println(num)
//        num++
//    }

//    var num: Int
//    do {
//        println("Ingresar numeros entre el 0 y el 999(salir ingresando 0): ")
//        num = readLine()!!.toInt()
//        if(num in 1..9){
//            println("1 digito")
//        }else {
//            if (num in 10..99) {
//                println("2 digito")
//            }else{
//                if (num in 100..999){
//                    println("3 digito")
//                }
//            }
//        }
//    }while (num != 0)

//    print("Ingresar la cota superior del intervalo: ")
//    val cota_sup: Int = readLine()!!.toInt()
//    var contador: Int = 0
//    for (i in 1..cota_sup){
//        print("Ingresar numeros: ")
//        val num: Int = readLine()!!.toInt()
//        if (num % 2 == 0){
//            contador++
//        }
//    }
//    println("La cantidad de numeros pares ingresados son: $contador")

//    print("Ingresar un numero: ")
//    val num: Int = readLine()!!.toInt()
//    when {
//        num > 0 -> println("Numero positivo")
//        num < 0 -> println("Numero negativo")
//        num == 0 -> println("Numero nulo")
//        else -> println("No se ingreso un numero")
//    }

//    var suma: Int = 0
//    for (i in 1..5){
//        print("Ingresar numero 1: ")
//        val num1: Int = readLine()!!.toInt()
//        print("Ingresar numero 2: ")
//        val num2: Int = readLine()!!.toInt()
//        print("Ingresar numero 3: ")
//        val num3: Int = readLine()!!.toInt()
//        suma += when{
//            num1 > num2 && num1 > num3 -> num1
//            num2 > num3 -> num2
//            else -> num3
//        }
//    }
//    println("Suma de los 5 mayores valores: $suma")

