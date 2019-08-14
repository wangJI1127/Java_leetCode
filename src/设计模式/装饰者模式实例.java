package 设计模式;

/**
 * 讲解内容网址： 以饮品和配料为例，饮品是被装饰者，配料是装饰者
 * https://blog.csdn.net/ma598214297/article/details/80699377
 */
public class 装饰者模式实例 {
    // 首先定义一个抽象父类
    static abstract class Beverage {//父类作为一个抽象类呈现
        String descriptionString = "未知饮料";

        //类型描述父类实现
        public String getDescription() {
            return descriptionString;
        }

        //子类需要实现的抽象方法
        public abstract double cost();
    }

    // 然后定义装饰者的父类
    static abstract class CondimentDecorator extends Beverage{
        // 调料材料子类必须实现的抽象方法
        public abstract String getDescription();
    }

    // 然后定义被装饰者，即抽象父类的子类
    static class HouseBlend extends Beverage{

        public HouseBlend(){
            descriptionString = "house blend coffee!";
        }

        @Override
        public double cost() {
            return 5;
        }
    }

    // 然后实现具体的装饰者
    static class Mocha extends CondimentDecorator{
        Beverage beverage;
        double myCost = 20;
        // 关于构造方法，我们需要引入被修饰对象的实例变量，所以就作为构造参数输入了。
        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        //关于description和cost方法，我们都是采用获取被修饰对象的属性，然后才去累加的方法作为新的输入，这样，新的属性能够一直叠加下去
        // （比如计算价格）。也就是说我们计算Mocha的价钱，我们首先获取被装饰对象的价钱，然后加上自身价值，算出总的金额。
        @Override
        public double cost() {
            return myCost + beverage.cost();
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + "mocha";
        }
    }
    // 装饰者2
    static class Whip extends CondimentDecorator{
        Beverage beverage;
        double myCost = 30;

        public Whip(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ",Whip";
        }

        @Override
        public double cost() {
            return myCost + beverage.cost();
        }
    }

    public static void main(String[] args) {
        //不加调料的HouseBlend
        Beverage beverage = new HouseBlend();
        System.out.println(beverage.getDescription()+"     $"+beverage.cost());

        Beverage beverage1 = new HouseBlend();
        Mocha mocha = new Mocha(beverage);
        System.out.println(mocha.getDescription()+ mocha.cost());
        Whip whip = new Whip(mocha);
        System.out.println(whip.getDescription()+ whip.cost());

    }

}
