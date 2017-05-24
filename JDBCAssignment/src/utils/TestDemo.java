package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Car;
import bean.Customer;
import bean.Member;
import bean.Model;
import bean.NonMember;
import bean.RentalCar;
import bean.Rents;
import bean.SoldCar;
import bean.Customer.Sex;
import service.CarService;
import service.CustomerService;
import service.MemberService;
import service.ModelService;
import service.NonMemberService;
import service.RentalCarService;
import service.RentsService;
import service.SoldCarService;

public class TestDemo {
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2014-01-05");
		Date date2 = sdf.parse("2014-01-06");
		Date date3 = sdf.parse("2014-01-08");
		Date date4 = sdf.parse("2015-01-05");
		Date date5 = sdf.parse("2015-03-03");
		Date date6 = sdf.parse("2015-03-05");
		Date date7 = sdf.parse("2015-03-07");
		Date date8 = sdf.parse("2016-04-07");
		
		
		ModelService modelService = new ModelService();
		System.out.println("Add model: ");
		Model model = new Model(10000001, "COMMON", "BDIC", 4);
		Model model2 = new Model(10000002, "GREAT", "BDIC", 6);
		Model model3 = new Model(10000003, "BAD", "BDIC", 4);
		modelService.regist(model);
		modelService.regist(model2);
		modelService.regist(model3);
		
		CarService carService = new CarService();
		System.out.println("Add Car: ");
		Car car = new Car(10100001, model, date);
		Car car2 = new Car(10100002, model2, date);
		Car car3 = new Car(10100003, model2, date2);
		Car car4 = new Car(10100004, model2, date3);
		Car car5 = new Car(10100005, model2, date8);
		carService.regist(car);
		carService.regist(car2);
		carService.regist(car3);
		carService.regist(car4);
		carService.regist(car5);

		CustomerService customerService = new CustomerService();
		System.out.println("Add customer: ");
		Customer customer = new Customer(500101, "Caption", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		Customer customer2 = new Customer(100123, "Yi", Sex.FEMALE, "NAU", "NanJing", "China", 188);
		Customer customer3 = new Customer(100124, "Wang", Sex.OTHER, "BJUT", "BeiJing", "China", 188);
		Customer customer4 = new Customer(100125, "Wei", Sex.MALE, "BJUT", "HangZhou", "China", 188);
		Customer customer5 = new Customer(100126, "Sun", Sex.MALE, "BJUT", "HangZhou", "China", 188);
		Customer customer6 = new Customer(100127, "Dong", Sex.MALE, "BJUT", "HangZhou", "China", 188);
		Customer customer7 = new Customer(100128, "Chen", Sex.MALE, "BJUT", "HangZhou", "China", 188);
		Customer customer8 = new Customer(100129, "Mao", Sex.MALE, "BJUT", "HangZhou", "China", 188);
		Customer customer9 = new Customer(100130, "Li", Sex.FEMALE, "NAU", "NanJing", "China", 188);
		Customer customer10 = new Customer(100131, "Kai", Sex.FEMALE, "NAU", "NanJing", "China", 188);
		Customer customer11 = new Customer(500102, "Chen", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		Customer customer12 = new Customer(500103, "Yao", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		Customer customer13 = new Customer(500104, "Gao", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		Customer customer14 = new Customer(500105, "Lu", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		customerService.regist(customer);
		customerService.regist(customer2);
		customerService.regist(customer3);
		customerService.regist(customer4);
		customerService.regist(customer5);
		customerService.regist(customer6);
		customerService.regist(customer7);
		customerService.regist(customer8);
		customerService.regist(customer9);
		customerService.regist(customer10);
		customerService.regist(customer11);
		customerService.regist(customer12);
		customerService.regist(customer13);
		customerService.regist(customer14);
		
		MemberService memberService = new MemberService();
		System.out.println("Add member: ");
		Member member = new Member(10200001, date, date, customer);
		Member member2 = new Member(10200002, date, date, customer3);
		Member member3 = new Member(10200003, date, date2, customer5);
		Member member4 = new Member(10200004, date, date3, customer6);
		Member member5 = new Member(10200005, date, date4, customer7);
		Member member6 = new Member(10200006, date, date4, customer8);
		Member member7 = new Member(10200007, date, date4, customer9);
		Member member8 = new Member(10200008, date, date5, customer10);
		Member member9 = new Member(10200009, date, date5, customer11);
		Member member10 = new Member(10200010, date, date6, customer12);
		Member member11 = new Member(10200011, date, date7, customer13);
		Member member12 = new Member(10200012, date, date7, customer14);
		memberService.regist(member);
		memberService.regist(member2);
		memberService.regist(member3);
		memberService.regist(member4);
		memberService.regist(member5);
		memberService.regist(member6);
		memberService.regist(member7);
		memberService.regist(member8);
		memberService.regist(member9);
		memberService.regist(member10);
		memberService.regist(member11);
		memberService.regist(member12);
		
		NonMemberService nonMemberService = new NonMemberService();
		System.out.println("Add nonMember: ");
		NonMember nonMember = new NonMember(customer2);
		NonMember nonMember2 = new NonMember(customer4);
		nonMemberService.regist(nonMember);
		nonMemberService.regist(nonMember2);
		
		RentalCarService rentalCarService = new RentalCarService();
		System.out.println("Add rentalCar: ");
		RentalCar rentalCar = new RentalCar(car, 100);
		RentalCar rentalCar2 = new RentalCar(car3, 80);
		RentalCar rentalCar3 = new RentalCar(car5, 50);
		rentalCarService.regist(rentalCar);
		rentalCarService.regist(rentalCar2);
		rentalCarService.regist(rentalCar3);

		SoldCarService soldCarService = new SoldCarService();
		System.out.println("Add soldCar: ");
		SoldCar soldCar = new SoldCar(10300001, nonMember.getSSN(), date4, date4, 2500, car2);
		SoldCar soldCar2 = new SoldCar(10300002, nonMember.getSSN(), date5, date5, 3000, car4);
		soldCarService.regist(soldCar);
		soldCarService.regist(soldCar2);
		
		RentsService rentsService = new RentsService();
		System.out.println("Add rents: ");
		Rents rents = new Rents(10400001, member, rentalCar, 100, date5, date5);
		Rents rents2 = new Rents(10400002, member2, rentalCar2, 120, date5, date5);
		Rents rents3 = new Rents(10400003, member3, rentalCar3, 300, date6, date7);
		rentsService.regist(rents);
		rentsService.regist(rents2);
		rentsService.regist(rents3);
	}
}
