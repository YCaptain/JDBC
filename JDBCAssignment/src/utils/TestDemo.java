package utils;

import java.util.Date;

import entity.Car;
import entity.Customer;
import entity.Customer.Sex;
import entity.Member;
import entity.Model;
import entity.NonMember;
import entity.RentalCar;
import entity.Rents;
import entity.SoldCar;
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
		Car car = new Car(10100001, model, new Date(System.currentTimeMillis()));
		Car car2 = new Car(10100002, model2, new Date(System.currentTimeMillis()));
		Car car3 = new Car(10100003, model2, new Date(System.currentTimeMillis()));
		Car car4 = new Car(10100004, model2, new Date(System.currentTimeMillis()));
		carService.regist(car);
		carService.regist(car2);
		carService.regist(car3);
		carService.regist(car4);

		CustomerService customerService = new CustomerService();
		System.out.println("Add customer: ");
		Customer customer = new Customer(500101, "Caption", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		Customer customer2 = new Customer(100123, "Yi", Sex.FEMALE, "NAU", "NanJing", "China", 188);
		Customer customer3 = new Customer(100124, "Wang", Sex.OTHER, "BJUT", "BeiJing", "China", 188);
		Customer customer4 = new Customer(100125, "Wei", Sex.MALE, "BJUT", "HanZhou", "China", 188);
		customerService.regist(customer);
		customerService.regist(customer2);
		customerService.regist(customer3);
		customerService.regist(customer4);
		
		MemberService memberService = new MemberService();
		System.out.println("Add member: ");
		Member member = new Member(10200001, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), customer);
		Member member2 = new Member(10200002, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), customer3);
		memberService.regist(member);
		memberService.regist(member2);
		
		NonMemberService nonMemberService = new NonMemberService();
		System.out.println("Add nonMember: ");
		NonMember nonMember = new NonMember(customer2);
		NonMember nonMember2 = new NonMember(customer4);
		nonMemberService.regist(nonMember);
		nonMemberService.regist(nonMember2);
		
		RentalCarService rentalCarService = new RentalCarService();
		System.out.println("Add rentalCar: ");
		RentalCar rentalCar = new RentalCar(car);
		RentalCar rentalCar2 = new RentalCar(car3);
		rentalCarService.regist(rentalCar);
		rentalCarService.regist(rentalCar2);

		SoldCarService soldCarService = new SoldCarService();
		System.out.println("Add soldCar: ");
		SoldCar soldCar = new SoldCar(10300001, nonMember.getSSN(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 2500, car2);
		SoldCar soldCar2 = new SoldCar(10300002, nonMember.getSSN(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 3000, car4);
		soldCarService.regist(soldCar);
		soldCarService.regist(soldCar2);
		
		RentsService rentsService = new RentsService();
		System.out.println("Add rents: ");
		Rents rents = new Rents(10400001, member, rentalCar, 100, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 80);
		Rents rents2 = new Rents(10400002, member2, rentalCar2, 100, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 80);
		rentsService.regist(rents);
		rentsService.regist(rents2);
	}
}
