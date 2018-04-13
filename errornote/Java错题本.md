1. Java中修饰符一种有以下几种：
   1. 访问控制修饰符

      public、private、protected、缺省

   2. 其他修饰符

      abstract、final、static、native、synchronized、transient、volatile

   3. 对于形式参数只能用final修饰符，其他任何修饰符都会引起编译器错误，但是这个修饰符有一个限制就是，在方法中不能对参数做任何修改。

   4. final修饰符一般在方法内部类使用

2. 子类的构造方法总是优先调用父类的构造方法，如果子类的构造方法没有明显地指明使用父类的那个构造方法，默认使用无参构造方法，但如果傅雷没有无参的构造函数，所以子类需要在自己的构造函数中显示的调用父类的构造函数。

3. Java中的关键字是对Java的编译器有特殊的意义，他们用来表示一种数据类型，或者表示程序的结构，关键字不能用变量名、方法名、类名、包名和参数

   - 其中true、false是boolean的变量值，是编译器赋予特定含义的，但并不是关键字。

4. 静态域执行顺序

   1. 静态块：用static声明，JVM加载类时执行，仅执行一次
   2. 构造块：类中直接用{}定义，每一次创建对象时执行
   3. 执行顺序：静态块》main》构造块》构造方法
   4. 其中静态块只是静态域的一种
   5. 静态域中包含了静态变量、静态块、静态方法，其中需要初始化的是静态变量和静态块，而他们两个初始化顺序是靠他们俩的位置决定的。

5. 事务盲点

   1. Java程序只是设定事务的隔离级别
   2. Hibernate 是一个java的数据持久化框架，方便数据库的访问
   3. 事务隔离级别由数据库实现，是数据库系统本身的一个功能
   4. JDBC是java database connector，也就是java访问数据库的驱动
   5. 为了解决更新丢失、脏读、不可重读，定义了四个事务隔离级别分别为：未授权读取（read uncommitted）、授权读取（read committed）、可重复读取（repeatable read）、序列化（Serializable）

6. Java 包

   1.  提供了包机制，包是类的容器，用于分割类名空间。
   2. 如果没有指定包名，所有的示例都属于一个默认的无名包。
   3. `Java` 是跨平台的，所以Java中的包和操作系统没有任何关系。
   4. `Java`的包是用来组织文件的一种虚拟文件系统。
   5. `import` 语句并没有将对应的`java`源文件拷贝到此处，仅仅是引用，包塑编译器有使用外部文件，编译的时候去读取这个外部文件。
   6. 同一个包内的类可以不经过 `import` 而直接相互使用。

7. 类加载的初始化问题

   1. 虚拟机在首次加载java类时，会对静态初始化块、静态成员变量、静态方法进行一次初始化。
   2. 只有在调用new方法时才会创建类的实例。
   3. 类实例创建过程：按照父子集成关系进行初始化，首先执行父类的初始化块部分，然后是父类的构造方法，再执行本类集成的子类的初始化块，最后是子类的构造方法。
   4. 类实例销毁的时候，首先销毁子类部分，再销毁父类部分。
   5. 整体的加载顺序：父类静态代码块》子类静态代码块》父类普通代码块》父类构造方法》子类普通代码块》子类构造方法。

8. java 进程同步的两种方法：

   1. 同步块
   2. 同步方法
   3. 对于同步来说都是使用`synchronized`方法。
   4. 每一个对象都有一个监视器，也就是我们说的锁。

9. java 类型装换

   1. 代码示例：

      ```java
      byte b1=1,b2=2,b3,b6;
      final byte b4=4,b5=6;
      b6=b4+b5;
      b3 = b1 + b2;
      ```

   2. 被final修饰的变量是常量，这里的b6=b4+b5可以看成是b6=10，在编译时就已经变成b6=10了

   3. b1 和 b2 是 byte 类型，java中计算时将他们提升为int类型，再进行计算，计算后是int类型，赋值给b3，b3是byte类型，类型不匹配编译不会通过，需要进行强制转换。

   4. Java 表达式转型规则：由低到高

      1. 所有的byte、short、char 类型的值将被提升为 int 型
      2. 如果有一个操作数是long、float、double，计算结果就是对应的类型

   5. 被final修饰的变量不会自定改变类型，当2个final修饰相操作时，结果会根据左边变量的类型而转化。

10. java 类

  1. 一个文件可以有多个类，可以使并列的类，也可以是外部类、内部类结合。
  2. 一个类中，可以有多个main方法，这是重载，但是 psvm(String[] args) 的方法只能有一个。
  3. 在一个类中可以有main方法，也可以没有main方法，而有一个main方法的时候，也可以时候也，也可以是任一访问权限，因为这个类不一定要执行，可以只是辅助类。
  4. Java 程序的main方法必须卸载类里面
  5. Java 程序中可以有多个名字为 main 方法

11. Java 抽象类和接口的比较

    1. 抽象类可以有构造，只不过不能new。
    2. 接口中可以有变量，但是无论怎样写，最后都是psf。
    3. 抽闲类中可以有静态方法，接口中也可以有。
    4. 接口中可以有非抽象的方法，比如default方法。
    5. 接口中可以带有方法体的方法。
    6. 接口中的方法默认是public的。

12. Thread run 和 start

    1. 若调用 start 方法，则县整形主线程，后执行子线程。
    2. 若调用 run 方法，相当于函数调用，顺序执行。

13. Object getClass 和 getName

    1. ```
       super.getClass().getName()
       返回：包名+类名
       ```

    2. ```
       super.getClass()
       返回：class 包名+类名
       ```

14. String 的理解

    1. ```java
       public class StringDemo{
           private static final String MESSAGE="taobao";
           public static void main(String [] args) {
               String a ="tao"+"bao";
               String b="tao";
               String c="bao";
               System.out.println(a==MESSAGE);
               System.out.println((b+c)==MESSAGE);
           }
       }
       ```

    2. 解释：

       对于这道题，考察的是对String类型的认识以及编译器优化。Java中String不是基本类型，但是有些时候和基本类型差不多，如String b = "tao" ; 可以对变量直接赋值，而不用 new 一个对象（当然也可以用 new）。所以String这个类型值得好好研究下。

       Java中的变量和基本类型的值存放于栈内存，而new出来的对象本身存放于堆内存，指向对象的引用还是存放在栈内存。例如如下的代码：

       **int**  i=1;

           String s =  **new**  String( "Hello World" );

       变量i和s以及1存放在栈内存，而s指向的对象”Hello World”存放于堆内存。


    [![img](http://static.oschina.net/uploads/img/201305/28181619_ugB3.jpg)](http://static.oschina.net/uploads/img/201305/28181619_ugB3.jpg)

 

       栈内存的一个特点是数据共享，这样设计是为了减小内存消耗，前面定义了i=1，i和1都在栈内存内，如果再定义一个j=1，此时将j放入栈内存，然后查找栈内存中是否有1，如果有则j指向1。如果再给j赋值2，则在栈内存中查找是否有2，如果没有就在栈内存中放一个2，然后j指向2。也就是如果常量在栈内存中，就将变量指向该常量，如果没有就在该栈内存增加一个该常量，并将变量指向该常量。


        [![img](http://static.oschina.net/uploads/img/201305/28181619_TJmL.jpg)](http://static.oschina.net/uploads/img/201305/28181619_TJmL.jpg)


       如果j++，这时指向的变量并不会改变，而是在栈内寻找新的常量（比原来的常量大1），如果栈内存有则指向它，如果没有就在栈内存中加入此常量并将j指向它。这种基本类型之间比较大小和我们逻辑上判断大小是一致的。如定义i和j是都赋值1，则i==j结果为true。==用于判断两个变量指向的地址是否一样。i==j就是判断i指向的1和j指向的1是同一个吗？当然是了。对于直接赋值的字符串常量（如String s=“Hello World”；中的Hello World）也是存放在栈内存中，而new出来的字符串对象（即String对象）是存放在堆内存中。如果定义String s=“Hello World”和String w=“Hello World”，s==w吗？肯定是true，因为他们指向的是同一个Hello World。

 

       [![img](http://static.oschina.net/uploads/img/201305/28181619_E8BZ.jpg)](http://static.oschina.net/uploads/img/201305/28181619_E8BZ.jpg)

 

       堆内存没有数据共享的特点，前面定义的String s =  **new**  String( "Hello World" );后，变量s在栈内存内，Hello World 这个String对象在堆内存内。如果定义String w = **new**  String( "Hello World" );，则会在堆内存创建一个新的String对象，变量w存放在栈内存，w指向这个新的String对象。堆内存中不同对象（指同一类型的不同对象）的比较如果用==则结果肯定都是false，比如s==w？当然不等，s和w指向堆内存中不同的String对象。如果判断两个String对象相等呢？用equals方法。

 

 

       [![img](http://static.oschina.net/uploads/img/201305/28181619_uF6N.jpg)](http://static.oschina.net/uploads/img/201305/28181619_uF6N.jpg)

 

       说了这么多只是说了这道题的铺垫知识，还没进入主题，下面分析这道题。 MESSAGE 成员变量及其指向的字符串常量肯定都是在栈内存里的，变量 a 运算完也是指向一个字符串“ taobao ”啊？是不是同一个呢？这涉及到编译器优化问题。对于字符串常量的相加，在编译时直接将字符串合并，而不是等到运行时再合并。也就是说
     
       String a =  "tao" + "bao" ;和String a =  "taobao" ;编译出的字节码是一样的。所以等到运行时，根据上面说的栈内存是数据共享原则，a和MESSAGE指向的是同一个字符串。而对于后面的(b+c)又是什么情况呢？b+c只能等到运行时才能判定是什么字符串，编译器不会优化，想想这也是有道理的，编译器怕你对b的值改变，所以编译器不会优化。运行时b+c计算出来的"taobao"和栈内存里已经有的"taobao"是一个吗？不是。b+c计算出来的"taobao"应该是放在堆内存中的String对象。这可以通过System. *out* .println( (b+c)== *MESSAGE* );的结果为false来证明这一点。如果计算出来的b+c也是在栈内存，那结果应该是true。Java对String的相加是通过StringBuffer实现的，先构造一个StringBuffer里面存放”tao”,然后调用append()方法追加”bao”，然后将值为”taobao”的StringBuffer转化成String对象。StringBuffer对象在堆内存中，那转换成的String对象理所应当的也是在堆内存中。下面改造一下这个语句System. *out* .println( (b+c).intern()== *MESSAGE* );结果是true， intern() 方法会先检查 String 池 ( 或者说成栈内存 ) 中是否存在相同的字符串常量，如果有就返回。所以 intern()返回的就是*MESSAGE*指向的"taobao"。再把变量b和c的定义改一下，
     
       ```java
       final  String b =  "tao" ;
     
       final  String c =  "bao" ;
     
       System. out .println( (b+c)== MESSAGE );
       ```
     
       现在b和c不可能再次赋值了，所以编译器将b+c编译成了”taobao”。因此，这时的结果是true。
     
       在字符串相加中，只要有一个是非final类型的变量，编译器就不会优化，因为这样的变量可能发生改变，所以编译器不可能将这样的变量替换成常量。例如将变量b的final去掉，结果又变成了false。这也就意味着会用到StringBuffer对象，计算的结果在堆内存中。
     
           如果对指向堆内存中的对象的String变量调用intern()会怎么样呢？实际上这个问题已经说过了，(b+c).intern()，b+c的结果就是在堆内存中。对于指向栈内存中字符串常量的变量调用intern()返回的还是它自己，没有多大意义。它会根据堆内存中对象的值，去查找String池中是否有相同的字符串，如果有就将变量指向这个string池中的变量。
     
       ```java
       String a = "tao"+"bao";
     
       String b = new String("taobao");
     
       System.out.println(a==MESSAGE); //true
     
       System.out.println(b==MESSAGE);  //false
     
       b = b.intern();
     
       System.out.println(b==MESSAGE); //true
     
       System. out .println(a==a.intern());  //true
     
       ```

java  类方法

1. 类方法是指类中被static修饰的方法，无this指针。
2. 可以将this理解为对象，而类方法属于类，不属于对象，所以类方法前不能加this指针。
3. 类方法示可以调用其他类的static方法的。
4. 可以在类中申请一个类对象或者参数穿第一个对象或者指针都可以调用。

对象互斥锁：

1. synchronized：给对象或者方法添加互斥锁，同一时间只能有一个对象或者方法执行这段代码
2. volatile：用来确保将变量的更新操作通知到其他线程，当把变量声明为valatile类型后，编译器与运行时都会注意到这个变量是共享的，因此不会将该变量上的操作与其他内存操作一起重排序，然而，在访问volatile变量时不会执行加锁操作，因此也就不会执行线程受阻塞，因此volatile变量是一种比synchhronized关键字更轻量级的同步机制
3. serialize：Java对象序列化为二进制
4. static：修饰变量、方法、静态代码块

Java 中声明变量的时候，如果使用的是包装类型，属于引用类型， `Byte x`。

又是一道类加载顺序：

```java
public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }
 
    public void callName()
    {
        System. out. println(baseName);
    }
 
    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}
```

1. 子类覆盖父类方法，是方法重写实现多态问题
2. Base b = new Sub(); 它为多态的一种表现方式，声明是Base，实现是 Sub类，可以理解为 b 编译时表现为Base类特性，运行时表现为Sub特性
3. 当子类覆盖了父类的方法后，意思是父类的方法已经被重写，体重父类初始化调用的方法为子类实现的方法，子类实现的方法中调用了baseName 为子类中的的私有属性。
4. 当执行到父类构造函数，子类非静态代码块和初始化步骤还没有到，子类中的baseName还没有被初始化，所以baseName为空。

Java 标识符

1. 标识符由26个英文字符大小写、数字、下划线和美元符号组成
2. 不能以数字开头，不能是关键字
3. 严格区分大小写
4. 标识符可以为任意长度

Java 支持的语言类型

1. 基本类型包括boolean类型和数值类型，
   1. 数值类型分为整型和浮点类型，
   2. 整型包括：byte、char、short、int、long。
   3. 浮点型：float和double
2. 引用类型包括类、接口和数组
3. Byte和Float数据基本类型的包装类型，属于引用类型。

Jsp 内置对象

1. 关于 `Exception`，当 `isErrorPage="false"`，用`errorPage=“error.jsp”`（isErrorPage默认是false）
2. 当`isErrorPage=“true”`,页面会直接使用`exception`

类方法

1. 在类方法中调用本类的类方法时可以直接调用。
2. 在类方法中可以通过创建实例对象调用类的实例方法。

forward 和 redirect 区别

1. 从地址栏显示来说

- forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址.



- redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.


2. 从数据共享来说

- forward:转发页面和转发到的页面可以共享request里面的数据.



- redirect:不能共享数据.


3. 从运用地方来说

- forward:一般用于用户登陆的时候,根据角色转发到相应的模块.



- redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.


4. 从效率来说

- forward:高.



- redirect:低.

  redirect 默认是302码，包含两次请求和两次响应。

对于赋值转化

1. intValue 是把 Integer 对象编程 int 的基础数据类型
2. parsenInt 是把 String 变成 int 的基础数据类型
3. ValueOf 是把 String 转化成 Integer 对象类型

equals 和 ==

1. == 比较的是两个变量的值是否相等

2. 对于引用型变量表示的是两个变量在堆中存储的的地址是否相同，即栈中的内容是否相同

3. ```java
   public static boolean isAdmin(String userId){
       return userId.toLowerCase()=="admin";
   }
   ```

4. 源码中 toLowerCase 是重新  `new String(result, 0, len+resultoffset)`  是一个新对象，不相等

内部类

1. 非静态内部类

2. 静态内部类

3. ```java
   public class Enclosingone {
       //非静态内部类
       public class InsideOne {}
       //静态内部类
       public static class InsideTwo{}
   }
 
   class Mytest02{
       public static void main(String args []){
           Enclosingone.InsideOne obj1 = new Enclosingone().new InsideOne();//非静态内部类对象
           Enclosingone.InsideTwo obj2 = new Enclosingone.InsideTwo();//静态内部类对象
       }
   }
   ```

4. 1.为什么使用内部类?

   使用内部类最吸引人的原因是：每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，

   对于内部类都没有影响

   1.1.使用内部类最大的优点就在于它能够非常好的解决多重继承的问题,使用内部类还能够为我们带来如下特性:

   (1)、内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独。

   (2)、在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。

   (3)、创建内部类对象的时刻并不依赖于外围类对象的创建。

   (4)、内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。

   (5)、内部类提供了更好的封装，除了该外围类，其他类都不能访问。

   2.内部类分类:

   (一).成员内部类:

   ```java
   public class Outer{
       private int age = 99;
       String name = "Coco";
       public class Inner{
           String name = "Jayden";
           public void show(){
               System.out.println(Outer.this.name);
               System.out.println(name);
               System.out.println(age);
           }
       }
       public Inner getInnerClass(){
           return new Inner();
       }
       public static void main(String[] args){
           Outer o = new Outer();
           Inner in = o.new Inner();
           in.show();
       }
   }
   ```

   1.Inner 类定义在 Outer 类的内部，相当于 Outer 类的一个成员变量的位置，Inner 类可以使用任意访问控制符，

   如 public 、 protected 、 private 等

   2.Inner 类中定义的 show() 方法可以直接访问 Outer 类中的数据，而不受访问控制符的影响，

   如直接访问 Outer 类中的私有属性age

   3.定义了成员内部类后，必须使用外部类对象来创建内部类对象，而不能直接去 new 一个内部类对象，

   即：内部类 对象名 = 外部类对象.new 内部类( );

   4.编译上面的程序后，会发现产生了两个 .class 文件: Outer.class,Outer$Inner.class{}

   5.成员内部类中不能存在任何 static 的变量和方法,可以定义常量:

   (1).因为非静态内部类是要依赖于外部类的实例,而静态变量和方法是不依赖于对象的,仅与类相关,

   简而言之:在加载静态域时,根本没有外部类,所在在非静态内部类中不能定义静态域或方法,编译不通过;

   非静态内部类的作用域是实例级别

   (2).常量是在编译器就确定的,放到所谓的常量池了

   ★★友情提示:

   1.外部类是不能直接使用内部类的成员和方法的，可先创建内部类的对象，然后通过内部类的对象来访问其成员变量和方法;

   2.如果外部类和内部类具有相同的成员变量或方法，内部类默认访问自己的成员变量或方法，如果要访问外部类的成员变量，

   可以使用 this 关键字,如:Outer.this.name

   (二).静态内部类: 是 static 修饰的内部类,

   1.静态内部类不能直接访问外部类的非静态成员，但可以通过 new 外部类().成员 的方式访问

   2.如果外部类的静态成员与内部类的成员名称相同，可通过“类名.静态成员”访问外部类的静态成员；

   如果外部类的静态成员与内部类的成员名称不相同，则可通过“成员名”直接调用外部类的静态成员

   3.创建静态内部类的对象时，不需要外部类的对象，可以直接创建 内部类 对象名 = new 内部类();

   ```java
   public class Outer{
       private int age = 99;
       static String name = "Coco";
       public static class Inner{
           String name = "Jayden";
           public void show(){
               System.out.println(Outer.name);
               System.out.println(name);       
           }
       }
       public static void main(String[] args){
           Inner i = new Inner();
           i.show();
       }
   }
   ```

   (三).方法内部类：其作用域仅限于方法内，方法外部无法访问该内部类

   (1).局部内部类就像是方法里面的一个局部变量一样，是不能有 public、protected、private 以及 static 修饰符的

   (2).只能访问方法中定义的 final 类型的局部变量,因为:

   当方法被调用运行完毕之后，局部变量就已消亡了。但内部类对象可能还存在,

   直到没有被引用时才会消亡。此时就会出现一种情况，就是内部类要访问一个不存在的局部变量;

   ==>使用final修饰符不仅会保持对象的引用不会改变,而且编译器还会持续维护这个对象在回调方法中的生命周期.

   局部内部类并不是直接调用方法传进来的参数，而是内部类将传进来的参数通过自己的构造器备份到了自己的内部，

   自己内部的方法调用的实际是自己的属性而不是外部类方法的参数;

   防止被篡改数据,而导致内部类得到的值不一致

   ```java
   /*
           使用的形参为何要为 final???
            在内部类中的属性和外部方法的参数两者从外表上看是同一个东西，但实际上却不是，所以他们两者是可以任意变化的，
            也就是说在内部类中我对属性的改变并不会影响到外部的形参，而然这从程序员的角度来看这是不可行的，
            毕竟站在程序的角度来看这两个根本就是同一个，如果内部类该变了，而外部方法的形参却没有改变这是难以理解
            和不可接受的，所以为了保持参数的一致性，就规定使用 final 来避免形参的不改变
            */
   public class Outer{
       public void Show(){
           final int a = 25;
           int b = 13;
           class Inner{
               int c = 2;
               public void print(){
                   System.out.println("访问外部类:" + a);
                   System.out.println("访问内部类:" + c);
               }
           }
           Inner i = new Inner();
           i.print();
       }
       public static void main(String[] args){
           Outer o = new Outer();
           o.show();
       }
   }
   ```

   **(3).注意:在JDK8版本之中,方法内部类中调用方法中的局部变量,可以不需要修饰为 final,匿名内部类也是一样的，主要是JDK8之后增加了 Effectively final 功能**

   [**http://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html**](http://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html)

   **反编译jdk8编译之后的class文件,发现内部类引用外部的局部变量都是 final 修饰的**

   (四).匿名内部类:

   (1).匿名内部类是直接使用 new 来生成一个对象的引用;

   (2).对于匿名内部类的使用它是存在一个缺陷的，就是它仅能被使用一次，创建匿名内部类时它会立即创建一个该类的实例，

   该类的定义会立即消失，所以匿名内部类是不能够被重复使用;

   (3).使用匿名内部类时，我们必须是继承一个类或者实现一个接口，但是两者不可兼得，同时也只能继承一个类或者实现一个接口;

   (4).匿名内部类中是不能定义构造函数的,匿名内部类中不能存在任何的静态成员变量和静态方法;

   (5).匿名内部类中不能存在任何的静态成员变量和静态方法,匿名内部类不能是抽象的,它必须要实现继承的类或者实现的接口的所有抽象方法

   (6).匿名内部类初始化:使用构造代码块！利用构造代码块能够达到为匿名内部类创建一个构造器的效果

   ```java
   public class OuterClass {
       public InnerClass getInnerClass(final int   num,String str2){
           return new InnerClass(){
               int number = num + 3;
               public int getNumber(){
                   return number;
               }
           };        /* 注意：分号不能省 */
       }
       public static void main(String[] args) {
           OuterClass out = new OuterClass();
           InnerClass inner = out.getInnerClass(2, "chenssy");
           System.out.println(inner.getNumber());
       }
   }
   interface InnerClass {
       int getNumber();
   }
   ```

Hibernate 使用的七大措施

1. 尽量使用many-to-one，避免使用单项one-to-many
2. 灵活使用单项 one-to-many
3. 不用一对一，使用多对一替代一对一
4. 配置对象缓存，不使用集合缓存
5. 一对多使用Bag，多对一使用Set
6. 继承使用显示多态HQL：from object asf = “exlicit” 避免到处查所有对象
7. 消除大表，使用二级缓存

Throwable

1. Error
2. Exception
   1. IOException
   2. Runtime Exception

静态变量只能在类主体中定义，不能再方法中定义。

1. 静态变量属于类所有而不属于方法

继承加载顺序

1. ```java
   Base b = new Sub();
   ```

2. 多态的一种表现形式，声明是 Base，实现是Sub 类，理解为 b 编译时表现为 Base 类特性，运行时表现为 Sub 类特性。

3. 当子类覆盖了父类的方法后，意思是父类的方法已经被重写，父类初始化调用的方法为子类实现的方法，子类实现的方法中调用的 baseName 为子类中的私有属性。

Volatile 关键字

1. 一旦一个共享变量（类的成员变量、类的静态成员变量）被 volatile 修饰后
2. 保证了不同线程对该变量进行操作时的可见性，即一个线程修改了某个变量的值，这个值对于其他的线程来说是立即可见的
3. 禁止进行指令重排序
4. volatile 只提供了保证访问该变量时，每次都是从内存中读取最新值，并不会使用寄存器缓存该值。
5. 每次都从内存中读取，而对该变量的修改，volatile 并不提供原子性的保证
6. 由于及时更新，很可能导致另一线程访问最新变量值，无法跳出循环，多线程下计数器必须使用锁保护。

getMethods 和 getDeclaredMethods 的区别

1. getMethods：返回某个类的所有public 方法包括其继承类的公用方法，当然包括他所实现接口的方法。
2. getDeclaredMethods：标识类或接口声明的所有的方法，包括公共，保护、默认访问、私有方法，但不包括继承的方法，当然也包括它所实现接口的方法。

url 本身的原因，把`{}` 的内容当成了占位符，而这里没有明确说明占位符对应的值，所以会导致报错

```java
String json = {"\"name\":\"jack\",\"age\":18"};
String url = "http://localhost:8080/search?people={json}";
String email = restTemplate.getForObject(url, String.class, json);
```
对于Application，主线程 main() 方法执行的线索，对于  applet  主线程是主线程加载并执行java小程序

java 类是单继承，java 接口是多继承，不允许类多重继承的主要原因是：如果A同事继承B和C，而B和C同事又有一个D方法，A 就不知如何继承那个了，但是对于接口全是抽象方法，就可以多继承。

依赖注入和控制反转（同一个概念，但有不同的侧重点）

1. 依赖注入：从应用程序的角度描述，可以把依赖注入描述完整点，应用程序依赖容器创建并注入他所需要的外部资源。
2. 控制反转：从容器的角度来描述，容器控制应用程序，由容器反向的向应用程序注入应用程序所需的外部资源。

java 正则表达式

1. ```java
   "com.jd.". replaceAll(".", "/") + "MyClass.class"
   ```

2. `.` 在正则表达式中标识任何字符，所以会把前面字符串的所有字符都替换成 `/` 。

3. 正则规则：

   1. .表示除\n之外的任意字符
   2. *表示匹配0-无穷
   3. +表示匹配1-无穷
   4. (?=Expression) 顺序环视，(?=\\()就是匹配正括号

java 常识

1. JDK5之后，J2SDK该名为 Java SE JDK，它是java开发编程的工具，提供了编译功能和圆形环境
2. appletviewer.exe 执行选项参数并没有jar选项
3. appletviewwer（小程序浏览器），是一种执行HTML文件上的Java小程序类的java浏览器，就是用来解释java applet 应用程序的，不需要写main函数。

Java 运算符的计算顺序

1. > 顺序： 括号>单元操作符>算术运算符>移位操作符>关系运算符>位运算符>逻辑运算符>三元操作符>赋值运算符

2. 单目运算符：+，-，++，--

   算数运算符：+，-，*，/，%

   移位运算符：<<,>>

   关系运算符：>,<,>=,<=,==,!=

   位运算符：&，|，~，^,

   逻辑运算符：&&，||

   三目运算符：表达式1？表达式2：表达式3;

   赋值运算符：=等

3. 特别容易混淆的符号：

   1. `<<`  表示左移位
   2. `>>`  表示右移位
   3. `>>>`  表示无符号右移
   4. 但是没有 `<<<` 运算符

Java 命令

1. java是运行指令：java 程序的名字但是不加后缀
2. javac 是编译命令：后面跟的java程序名字要加后缀

![img](https://uploadfiles.nowcoder.net/images/20160717/6316247_1468761643205_9F7B85AB04292CF73778D98998A20ED1)

1. == 比较的是地址，但是当为基本类型时，比较的就是值
2. 如果两边有包装类型，则现将包装类型装换为基本类型，再进行比较是否相等
3. 如果两边都为包装类，即为对象，比较的就是地址

finally 在 try-catch 语句中，一定会执行

1. finally 中有return语句，当try执行到return时会执行finally中的代码其中有return就直接返回了。

2. 栗子：

   ```java
   public static int func (){
       try{
           return 1;
       }catch (Exception e){
           return 2;
       }finally{
           return 3;
       }
   }
   ```

3. finally 中不含return语句，那么当执行return时，它会被保存等待finally执行完毕后返回，但是这个时候无论finally内部如何改变这个值，都不会影响返回结果。

4. 栗子：

   ```java
   public static int func1(){
       int i = 0 ;
       int test(){
           try {
               return i;
           } catch (Exception e) {
               return -1;
           }finally{
               i++;
           }
       }
   }
   ```

算法包括0个或多个输入，一个或多个输出，中间有穷个处理过程

1. 存储结构不属于算法结构
2. 算法的五个特性：
   1. 有穷性：必须能在有限个步骤之后终止
   2. 确定性：每一步骤必须有确切的定义
   3. 输入项：一个算法有0个或多个输入，以刻画运算对象的初始情况，所谓0个输入是指算法本身指定了初始条件。
   4. 输出项：一个算法有一个或多个输出，以反映对输入数据加工后的结果，没有输出的算法毫无意义。
   5. 可行性：算法中执行的任何计算步骤都是可以被分解为基本的可执行的操作步骤，即每个计算都可以在有限时间内完成

Tomcat 为每个 App 创建一个 Loader，里面保存着此 、WebApp 的 ClassLoader，需要加载WebApp下的类时，就取出ClassLoader来使用。

在switch(exp1) 中，exp1 只能是一个整数表达式或者枚举常量

1. 整数表达式可以是 int 基本类型或 Integer 包装类型，由于 byte，short，char 都可以隐含装换为 int ，所以这些类型以及这些类型的包装类型也是可以的
2. 显然，long、float、double 类型都不符合switch的语法规定，并且不能被隐式转换成int类型
3. String 类型是 Java 7 开始支持的

实现接口，就要实现接口里面的所有方法，相当于重写，重写需要满足：（三同一大一小）

1. 方法名相同
2. 返回值相同
3. 形参相同
4. 访问权限大于等于重写前
5. 抛出异常小于等于重写前
6. 接口时隐式抽象的，当声明一个接口的时候，不必使用abstract关键字
7. 接口中每个方法也是隐式抽象的，声明时同样不需要abstract关键字
8. 接口中的方法都是共有的

泛型仅仅是java语法糖，他不会影响java虚拟机生成的汇编代码，在编译阶段，虚拟机就会把泛型的类型擦除，还原成没有泛型的代码，顶多编译速度稍微慢一些，执行速度是完全没有什么影响的。

1. 泛型只是在编译的时候保证数据类型的正确性，和运行期间的性能无关

类 、内部类、局部内部类

1. 类：只能使用public、default、abstract（此类只能被继承）、final（标识此类不能被继承）修饰。
2. 内部类：和成员变量一样可以用所有访问权限修饰符修饰。
3. 局部内部类：和局部变量一样不能用访问权限修饰符修饰。

java.io.PrintWriter：用来创建一个文件并向文本文件写入数据

1. 栗子：

   ```java
   public static void main(String[] args) throws FileNotFoundException{
       File file=new File("num.txt");//文件对象
       if(file.exists()){
           System.out.print("文件已经存在！");
           System.exit(0);
       }
       PrintWriter out=new PrintWriter(file);//由文件对象构造一个写出器
       out.println("John,Where are you?");
       out.println("I'am here!");
       out.println("How old are you?");
       out.println(15);
       //关闭写出器
       out.close();
   }
   ```

ServletContext 和 ServletConfig 的区别

1. ServletContext：Servlet 容器在启动时会加载web应用，并为每个web应用创建唯一的Servlet Context 对象，可以把 ServletContext 看成是一个 Web应用的服务器端组件的共享内存，在ServletContext中可以存放共享数据 。ServletContext 对象是一个真正的全局对象，凡是 web容器中的`Servlet`都可以访问。
2. 整个Web应用只有唯一的一个ServletContext对象。
3. ServletConfig对象：用于封装Servlet的配置信息，从一个Servlet被实例化后，对任何客户端在任何时候访问有效，但仅对Servlet自身有效，一个Servlet的ServletConfig对象不能被另一个Servlet访问。

Servlet 和 CGI 的比较

1. 当用户浏览器发出一个Http/CGI 的请求，或者调用一个CGI程序的时候，服务器端就要启用一个线程（而且每次都要调用），调用CGI程序越多，就要消耗系统越多的处理时间，对于高并发显然，鸡肋，对比Servlet就是每次调用时，会启动线程，这样可以充分利用系统资源。
2. 传统的CGI程序，不具备平台无关特性，系统环境发生变化，CGI程序就要瘫痪，而 Servlet 具备Java的平台无关性，在系统开发过程中保持了系统的扩展性和高效性。
3. 对于数据库层面也是，Servlet 有连接池的概念，可以利用多线程的优点，在系统缓存中事先建立好若干链接。

子类的构造方法总是先调用父类的构造方法，如果子类的构造方法没有明显地指明使用父类的那个构造方法，子类就调用父类不带参数的构造方法，

1. 父类没有无参的构造函数，所以子类需要在自己的构造函数中显示的调用父类的构造函数。

能够进行对象传输的是：`ObjectOutputStream` 和 `ObjectInputStream`

在包装类中，对 `equals` 方法重写，会先用 `instanceof` 比较是否属于该类，如果不属于，直接返回 `false`

1. `Integer` 栗子：

   ```java
   public boolean equals(Object obj) {
       if (obj instanceof Integer) {
           return value == ((Integer)obj).intValue();
       }
       return false;
   }
   ```

抽象类的小抄：

1. 抽象类不能被实例化，实例化的工作应该交由他的子类完成，他只需要一个引用即可。
2. 抽象方法必须由子类来进行重写
3. 只要包含一个抽象方法的类，该类必须要定义成抽象类，不管是否包含其他方法
4. 抽象类可以包含具体的方法，当然也可以不包含抽象方法
5. abstract 不能与 final 并列修饰同一个类
6. abstract 不能与private、static、final 或 native 并列修饰同一个方法。

静态方法的理解

1. 类对方法的调用，不是对象方法的调用
2. static 静态方法，直接使用“类.方法”即可，因为静态方法使用不依赖对象是否创建
3. null 可以被强制类型装换成任意类型，注意不是任意类型对象，因此可以通过它来执行静态方法
4. 非静态的方法，必须依赖对象被创建后才能使用

java 不允许单独的方法，过程或者函数存在，必须要隶属于某一个类中

1. java 语言中的方法属于对象的成员，而不是类的成员，不过，其中静态方法属于类的成员。

java 引用理解

1. 只要是引用传递，对引用的修改直接影响着原对象 （:x:）
2. 只有对应用对象的内部做了修改，才会影响原对象
3. 如果直接将引用修改了，则对原对象没有影响，唯一的影响是：这个被修改的引用，现在不是原来对象的引用，二是新对象的引用。
4. 引用传递指的是传递的时候，传递的是对象的运用，如果对引用的内部成员进行操作，则会直接影响到原对象，但是如果直接把此引用指向了其他对象，那么对不起，这个引用从此以后，便于之前的对象没有任何关系，当前代表仅仅是新指向的对象。

#### full GC触发的条件

除直接调用System.gc外，触发Full GC执行的情况有如下四种。

1. ##### 旧生代空间不足

  旧生代空间只有在新生代对象转入及创建为大对象、大数组时才会出现不足的现象，当执行Full GC后空间仍然不足，则抛出如下错误：
  java.lang.OutOfMemoryError: Java heap space
  为避免以上两种状况引起的FullGC，调优时应尽量做到让对象在Minor GC阶段被回收、让对象在新生代多存活一段时间及不要创建过大的对象及数组。

2. ##### Permanet Generation空间满

  PermanetGeneration中存放的为一些class的信息等，当系统中要加载的类、反射的类和调用的方法较多时，Permanet Generation可能会被占满，在未配置为采用CMS GC的情况下会执行Full GC。如果经过Full GC仍然回收不了，那么JVM会抛出如下错误信息：
  java.lang.OutOfMemoryError: PermGen space
  为避免Perm Gen占满造成Full GC现象，可采用的方法为增大Perm Gen空间或转为使用CMS GC。

3. ##### CMS GC时出现promotion failed和concurrent mode failure

  对于采用CMS进行旧生代GC的程序而言，尤其要注意GC日志中是否有promotion failed和concurrent mode failure两种状况，当这两种状况出现时可能会触发Full GC。
  promotion failed 是在进行Minor GC时，survivor space放不下、对象只能放入旧生代，而此时旧生代也放不下造成的；

  concurrent mode failure 是在执行CMS GC的过程中同时有对象要放入旧生代，而此时旧生代空间不足造成的。
  应对措施为：增大survivorspace、旧生代空间或调低触发并发GC的比率，但在JDK 5.0+、6.0+的版本中有可能会由于JDK的bug29导致CMS在remark完毕后很久才触发sweeping动作。对于这种状况，可通过设置-XX:CMSMaxAbortablePrecleanTime=5（单位为ms）来避免。

4. ##### 统计得到的Minor GC晋升到旧生代的平均大小大于旧生代的剩余空间

  这是一个较为复杂的触发情况，Hotspot为了避免由于新生代对象晋升到旧生代导致旧生代空间不足的现象，在进行Minor GC时，做了一个判断，如果之前统计所得到的Minor GC晋升到旧生代的平均大小大于旧生代的剩余空间，那么就直接触发Full GC。
  例如程序第一次触发MinorGC后，有6MB的对象晋升到旧生代，那么当下一次Minor GC发生时，首先检查旧生代的剩余空间是否大于6MB，如果小于6MB，则执行Full GC。
  当新生代采用PSGC时，方式稍有不同，PS GC是在Minor GC后也会检查，例如上面的例子中第一次Minor GC后，PS GC会检查此时旧生代的剩余空间是否大于6MB，如小于，则触发对旧生代的回收。
  除了以上4种状况外，对于使用RMI来进行RPC或管理的Sun JDK应用而言，默认情况下会一小时执行一次Full GC。可通过在启动时通过- java-Dsun.rmi.dgc.client.gcInterval=3600000来设置Full GC执行的间隔时间或通过-XX:+ DisableExplicitGC来禁止RMI调用System.gc。

java 访问权限

1. java的访问权限有 public、protected、private、default的，default 不能修饰变量
2. 普通变量不能用abstract修饰，abstract一般修饰方法和类
3. native：修饰的方法简单来说就是：一个Java方法调用了一个非Java代码的接口
4. 定义native方法时，并不提供实现类，因为其实现体是用非Java语言在外面实现的
5. native 可以和任何修饰符连用，abstract除外，因为native暗示这个方法有实现体，而abstract却显示指明了这个方法没有实现体。

Java 加载驱动方法

1. Class.forName("com.mysql.jdbc.Driver()")
2. DriverManager.registerDriver("com.mysql.jdbc.Driver()")
3. System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver()")

MySQL 索引

1. ![img](https://uploadfiles.nowcoder.net/images/20170815/5994168_1502785746568_3872455FABFD1B29AF3688B49786FD79)
2. MySQL 组合索引（复合索引）的最左优先原则，最左优先原则就是说组合索引的第一个字段必须出现在查询组句中，这个索引才会被用到。
3. 只要组合索引最左边第一个字段出现在Where中，那么不管后面的字段出现顺序如何，MySQL引擎都会自动调用索引来优化查询效率
4. 最左匹配原则可以知道B-Tree建立索引的过程，比如假设有一个3列索引（col1,col2,col3）,那么MySQL只会建立三个索引(col1)、（col1，col2）、（col1，col2，col3）
5. 最后总结就是，带头大哥不能死，中间兄弟不能断

java 异常

- Java 异常分为运行时异常和非运行异常也叫检查式异常
- 运行时异常：
  - ClassCastException
  - ClassNotFoundException
  - IndexOutOfBoundsException
  - NullPointerException
  - ArrayStoreException
  - BufferOverflowException
- 检查异常
  - IOException
  - SQLException

Byte 在内存中占一个字节，范围是 -128 到 127  之间，将128 强制类型转换为 byte 型，就超出了byte型的范围，128  的二进制存储是 1000 0000 转换为 byte 型后，最高位时符号位，值是 -128。

#### java 基本类型默认值

| 默认值  | 存储需求（字节） | 取值范围 | 示例         |                    |
| ------- | ---------------- | -------- | ------------ | ------------------ |
| byte    | 0                | 1        | -2^7—2^7-1   | byte b=10;         |
| char    | ‘ \u0000′        | 2        | 0—2^16-1     | char c=’c’ ;       |
| short   | 0                | 2        | -2^15—2^15-1 | short s=10;        |
| int     | 0                | 4        | -2^31—2^31-1 | int i=10;          |
| long    | 0                | 8        | -2^63—2^63-1 | long o=10L;        |
| float   | 0.0f             | 4        | -2^31—2^31-1 | float f=10.0F      |
| double  | 0.0d             | 8        | -2^63—2^63-1 | double d=10.0;     |
| boolean | false            | 1        | true\false   | boolean flag=true; |

- 注意其中的 char 为 无符号类型，char 和  short 的标识范围相同，都是两个字节。

#### JVM 区域划分

- 方法区在 JVM 中也是一个非常重要的区域，它与堆一样，是被线程共享的区域，在方法区中，存储了每个类的信息（包括类的名称、方法信息、字段信息）、静态变量、常量以及编译器变异后的代码。
- JVM 初始运行的时候都会分配好 Method Area（方法区）和 堆（Heap） ，而 JVM 每遇到一个线程，就为其分配一个 Program Counter Register（程序计数器）、VM Stack（虚拟机栈）、Native Method Stack （本地方法栈），当线程终止时，三者所占用的内存空间也会被释放掉，这也就是为什么我们把内存分为线程共享和非线程共享的原因，非线程共享的那三个区域的生命周期与所属于线程相同，而线程共享的内存的区域与 Java 程序运行的生命周期相同，所以这也是系统垃圾回收的场所发生在线程共享的区域的原因。

#### 父子类类型转换

- 向上转型，父类的引用无法访问子类独有的方法。

#### 字符使用单引号、字符串使用双引号

#### 流程控制语句

- 顺序结构：
- 选择结构：if、switch
- 循环结构：while、for

#### Java 中的原始类型就是基本类型，基本类型就是那 8 种，其余的起开。

#### final 用于定义常量、而 const 是 c  和  c++ 中使用的。

#### Java 静态代码块

- 无法直接调用静态初始化块
- 在创建第一个实例前或任何静态成员之前，将自动调用静态初始化块来初始化
- 静态初始化块既没有访问修饰符，也没有参数

#### Java  作用域

作用域         当前类          同一package           子孙类                其他package

public                √                    √                           √                             √

protected         √                    √                            √                            ×

defalt                 √                    √                            ×                            ×

private              √                     ×                            ×                             ×

![img](https://uploadfiles.nowcoder.net/images/20161223/415611_1482452665193_6FB53C51539B47559CF0D122A832CF63)

 

JRE 判断一个程序是否执行完是通过所有的前台线程是否执行完毕。

JSP页面可以后缀可以使用 xxx.jsp

------

对于静态代码块和静态变量的定义：

- 两者可以同名，跟声明位置没有关系
- 即使两者名称相同，起作用的是 静态变量
- 内部声明和外部的作用域不同

------

#### 继承问题深入：

一般父类和子类的继承关系， `Super subToSuper = new Sub();` 出现这种情况，一般要是子类重写父类方法，则就是访问子类的方法，但是特殊情况是：若父类的是静态方法则不能被珍惜类重写，而是被隐藏，子类只能是继承父类的静态方法。对于此问题还得补充一条就是，对于非静态的变量父子类同事存在的时候，当然是调用父类的了，只有方法才有子类的份，有点惨。

```
结论是：静态属性和静态方法只是可以继承没有表现出多态性。
因为静态方法和静态属性没有采用动态绑定。具体表现就是，
将子类实例向上转型则会调用到基类中的静态方法和属性，
不转型就调用子类自身的静态方法和属性。
编译器不推荐通过实例去调用静态方法和属性，因为这种调用方式容易造成混淆。

实际上，在Java的规范中，Java对于类的方法和属性采用了两种完全不同的处理机制：
对于方法，使用重载机制实现了多态性；对于属性，使用的是同名属性隐藏机制。
所谓的同名属性隐藏机制是指：在具有父子关系的两个类中，
子类中相同名字的属性会使得从父类中继承过来的同名属性变得不可见，
不管类型是否一致，名称一致的两个属性就是同名属性。
在子类中，无法简单地通过属性名称来获取父类中的属性，
而是必须通过父类名称加属性名称(super.变量名)的方法才可以访问父类中的该属性。
一般而言，为了代码容易阅读，极其不建议在父类和子类中使用同名属性。
```

------

`Byte`  是 `byte` 的包装类型，初始化为 `null`  不是  `0`。

包装类就是不一般。

```java
public class Test0413 {
    int a = (int)8846.0;
    static Integer aa;
    static Byte bb;
    static Character cc;
    public static void main(String[] args) {
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
    }
}
结果：
null
null
null
```

------

锁机制：

最基本的原则：原子性和可见性

原子性：某一时刻，同一段代码只有一个线程执行，防止冲突。

可见性：释放锁之前对于共享数据做出的更改对于随后获得该锁的另一个线程是可见的

原理：当对象获取锁之前，首先将自己的高速缓存无效，从主内存中装入变量，结束时，同步数据主内存更新。

某些情况可以不必同步：

- 由静态初始化器（在静态字段上或 static 块中的初始化器）
- 初始化数据时
- 访问 `final` 时
- 在创建线程之前，创建对象时
- 线程可以看见他将要处理的对象

synchronized 不足：

- 无法中断一个正在等候获得锁的线程
- 无法通过投票获得锁，如果不想等下去，也就没有办法获得锁
- 同步还要求锁的释放只能在与获得锁所在的堆栈相同的堆栈帧中进行

ReentrantLock：

- `java.util.concurrent.lock` 是 Java 中 Lock 框架锁定的一个抽象
- `ReentrantLock` 类实现了 Lock ，他拥有与 synchronized 相同的并发性和内存语义，添加了类似 锁投票、定时锁等候、可中断锁等候。
- 为了保证锁最终被释放，要把互斥区放入 try 中，释放锁放在 finally 中。

```java
class ReentrantLockDemo {    
    private Lock lock = new ReentrantLock();// 锁对象    

    public void output(String name) {           
        lock.lock();      // 得到锁    

        try {    
            for(int i = 0; i < name.length(); i++) {    
                System.out.print(name.charAt(i));    
            }    
        } finally {    
            lock.unlock();// 释放锁    
        }    
    }    
}  
```

Condition：

- Condition 用 `await()` 替换 `wait()`，用 `signal()` 替换 `notify()`，用 `signalAll()` 替换 `notifyAll()`
- Condition 绑定到 Lock 上，需要创建一个 Lock 的 Condition 必须用 `new  Condition()`

```java
class ReentrantLockDemo {  
    final Lock lock = new ReentrantLock();          //锁对象  
    final Condition notFull  = lock.newCondition(); //写线程锁  
    final Condition notEmpty = lock.newCondition(); //读线程锁  

    final Object[] items = new Object[100];//缓存队列  
    int putptr;  //写索引  
    int takeptr; //读索引  
    int count;   //队列中数据数目  

    //写  
    public void put(Object x) throws InterruptedException {  
        lock.lock(); //锁定  
        try {  
            // 如果队列满，则阻塞<写线程>  
            while (count == items.length) {  
                notFull.await();   
            }  
            // 写入队列，并更新写索引  
            items[putptr] = x;   
            if (++putptr == items.length) putptr = 0;   
            ++count;  

            // 唤醒<读线程>  
            notEmpty.signal();   
        } finally {   
            lock.unlock();//解除锁定   
        }   
    }  

    //读   
    public Object take() throws InterruptedException {   
        lock.lock(); //锁定   
        try {  
            // 如果队列空，则阻塞<读线程>  
            while (count == 0) {  
                notEmpty.await();  
            }  

            //读取队列，并更新读索引  
            Object x = items[takeptr];   
            if (++takeptr == items.length) takeptr = 0;  
            --count;  

            // 唤醒<写线程>  
            notFull.signal();   
            return x;   
        } finally {   
            lock.unlock();//解除锁定   
        }   
    }
}
```

------

Java 锁 分类：

- 自旋锁：自旋、JVM 默认10次，由 JVM 自己控制，For 去争抢锁
- 阻塞锁：被阻塞的线程，不会争夺锁
- 可重入锁：多次进入改锁的域
- 读写锁：
- 互斥锁：锁本身是互斥的
- 悲观锁：不相信，这里会是安全的，必须全部上锁
- 乐观锁：相信，这里是安全的
- 公平锁：有优先级的锁
- 非公平锁：无优先级
- 偏向锁：无竞争不锁，有竞争挂起，转为轻量锁
- 对象锁：对象加锁
- 线程锁：线程加锁
- 针粗化：多锁变成一个自己处理
- 轻量级锁：CAS 实现
- 针消除：偏向锁就是针消除的一种
- 锁膨胀：JVM 实现，针粗化
- 信号量：使用阻塞锁实现的一种策略
- 排它锁：X 锁，若事务T对数据对象A加上X锁，则只允许T读取和修改A，其他任何事务都不能再对A加任何类型的锁，直到T释放A上的锁。这就保证了其他事务在T释放A上的锁之前不能再读取和修改A。

------

#### 会话追踪技术：

- Cookie
  - 不BB，跟踪 cookie 名字必须是 JESSIONID
- URL 重写
  - 必须将所有的发送到客户端的url进行编码，调用 `HTTPServletResponse` 接口中的 `encodeURL()` 方法和 `encodeRedirectURL()` 方法来实现。
  - 在调用 `sendRedirect()` 方法之前使用 `encodeRedirectURL()` 方法。
- 隐藏表单域
  - 使用隐藏表单域，用来存储相关回话信息。