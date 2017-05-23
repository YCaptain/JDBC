package utils;

import java.util.Date;

import entity.Car;
import entity.Car.Status;
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
		Model model = new Model("COMMON", "BDIC", 4);
		modelService.regist(model);
		
		CarService carService = new CarService();
		System.out.println("Add Car: ");
		Car car = new Car(10100001, "COMMON", Status.RENTAL, new Date(System.currentTimeMillis()));
		Car car2 = new Car(10100002, "COMMON", Status.SOLD, new Date(System.currentTimeMillis()));
		carService.regist(car);
		carService.regist(car2);

		CustomerService customerService = new CustomerService();
		System.out.println("Add customer: ");
		Customer customer = new Customer(500101, "Caption", Sex.MALE, "BDIC", "BeiJing", "China", 188);
		Customer customer2 = new Customer(100123, "Yi", Sex.FEMALE, "NAU", "NanJing", "China", 188);
		customerService.regist(customer);
		customerService.regist(customer2);
		
		MemberService memberService = new MemberService();
		System.out.println("Add member: ");
		Member member = new Member(10200001, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), customer);
		memberService.regist(member);
		
		NonMemberService nonMemberService = new NonMemberService();
		System.out.println("Add nonMember: ");
		NonMember nonMember = new NonMember(customer2);
		nonMemberService.regist(nonMember);
		
		RentalCarService rentalCarService = new RentalCarService();
		System.out.println("Add rentalCar: ");
		RentalCar rentalCar = new RentalCar(car);
		rentalCarService.regist(rentalCar);

		SoldCarService soldCarService = new SoldCarService();
		System.out.println("Add soldCar: ");
		SoldCar soldCar = new SoldCar(10300001, nonMember.getSSN(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 2500, car2);
		soldCarService.regist(soldCar);
		
		RentsService rentsService = new RentsService();
		System.out.println("Add rents: ");
		Rents rents = new Rents(10400001, member, rentalCar, 100, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 80);
		rentsService.regist(rents);
	}
}
