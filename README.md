# Portcontainer

Să se implementeze clasa PortContainer ce implementează interfețele Cloneable și
Numarabil pentru a permite deep-copy între obiecte. Clasa PortContainer conține atributele
private:

• etichetă (șir de caractere);

• tipContainer (un atribut de tip enum cu valorile Mic_10mc, Mediu_25mc,
Mare_50mc, Jumbo_100mc);

• nrContainere (int[] – masiv ce stochează numarul de containere din fiecare tip).
Pentru clasa PortContainer se vor implementa constructorii considerați necesari. Se vor
implementa metode pentru accesul la valorile atributelor clasei, pentru setarea acestora și se
va suprascrie metoda String toString().


Se va implementa metoda int getCapacitate(), definită în interfața Numarabil, utilizând
numărul containerelor ce pot fi încărcate pe navă, împreună cu informația de volum
corespunzătoare tipului de container.


Să se implementeze clasa Macara, ce conține următoarele atribute private:

• tipContainer (Mic_10mc, Mediu_25mc, Mare_50mc, Jumbo_100mc – vezi mai sus);

• timpManipulare (milisecunde, int).

Pentru clasa Macara se vor implementa constructorii și metodele considerate a fi necesare.
Să se definească interfața Descarcare ce va conține metoda int DescarcaContainer(PortContainer, Macara), metodă ce va returna numărul de containere rămas de descărcat de pe nava PortContainer, din tipul de container manipulat de către instanța de Macara primită ca parametru de intrare în metodă.
Să se construiască o flotă de portcontainere ca o colecție de obiecte și să se populeze
această colecție cu cel puțin 3 instanțe de PortContainer.
Să se implementeze salvarea colecției de PortContainer într-un fișier text: PortContainere.csv. Fiecare linie a fișierului va conține atributele unui PortContainer,separate prin caracterul virgulă. Să se implementeze citirea fișierului text creat anterior și refacerea în memorie a colecției de PortContainer utilizând un alt tip de colecție.
Pe baza interfeței Descarcare, să se realizeze descărcarea unei nave PortContainer prin intermediul unor macarale robotizate. Fiecare macara este capabilă să manipuleze un anumit tip de container. Macaralele robotizate sunt controlate în fire de execuție distincte. La un moment dat doar o singură macara poate să ridice un container de un anumit tip de pe navă, celelalte macarale trebuind să aștepte. Să se programeze lucrul concurențial al macaralelor robotizate astfel încât de pe nava PortContainer să fie descărcate toate containerele pe care le-a transportat.
