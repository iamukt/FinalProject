package dao;

import java.util.List;

import dto.Reviews;

public interface ReviewsDao
{
	public List<Reviews> listReviews(int isbn);
	public boolean addReview(int isbn,String review);
}
