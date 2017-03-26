package cinema.model;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;

public class Booking implements InitializingBean {
	private Long id;

	private String filmName;

	private Date date;

	private Integer seat;

	private Double price;
	
	private State state;

	private Person client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Person getClient() {
		return client;
	}

	public void setClient(Person client) {
		this.client = client;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", filmName=" + filmName + ", date=" + date + ", seat=" + seat + ", price=" + price
				+ ", state=" + state + ", client=" + client + "]";
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Callback Booking bean added "+ this.getFilmName());
	}

}
