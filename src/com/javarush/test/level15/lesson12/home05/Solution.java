package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали
конструкторам класса Solution.
*/

public class Solution {
    public Solution(int b){}
    public Solution(float b){}
    public Solution(double b){}

    protected Solution(Integer b){}
    protected Solution(Float b){}
    protected Solution(Double b){}

    private Solution(String b){}
    private Solution(boolean b){}
    private Solution(char b){}

    Solution(Object b){}
    Solution(Character b){}
    Solution(Boolean b){}
}


