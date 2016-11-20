package mappingrelation;

public class Pay {
	private Worker worker;
	private int monthPay;
	private int yearPay;
	private int vacationWithPay;

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public int getMonthPay() {
		return monthPay;
	}

	public void setMonthPay(int monthPay) {
		this.monthPay = monthPay;
	}

	public int getYearPay() {
		return yearPay;
	}

	public void setYearPay(int yearPay) {
		this.yearPay = yearPay;
	}

	public int getVacationWithPay() {
		return vacationWithPay;
	}

	public void setVacationWithPay(int vacationWithPay) {
		this.vacationWithPay = vacationWithPay;
	}
}
