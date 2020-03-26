package kr.multi.bigdataShop.product.comment;

public class ProductCommentDTO {
	public String prd_no;
	public String mem_id;
	public String pro_comment;
	public String writedate;
	public String countnum;
	
	@Override
	public String toString() {
		return "ProductCommentDTO [prd_no=" + prd_no + ", mem_id=" + mem_id + ", pro_comment=" + pro_comment
				+ ", writedate=" + writedate + ", countnum=" + countnum + "]";
	}

	public ProductCommentDTO(String prd_no, String mem_id, String pro_comment, String writedate, String countnum) {
		super();
		this.prd_no = prd_no;
		this.mem_id = mem_id;
		this.pro_comment = pro_comment;
		this.writedate = writedate;
		this.countnum = countnum;
	}

	public String getCountnum() {
		return countnum;
	}

	public void setCountnum(String countnum) {
		this.countnum = countnum;
	}

	public ProductCommentDTO() {
		
	}
	
	public String getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(String prd_no) {
		this.prd_no = prd_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getPro_comment() {
		return pro_comment;
	}
	public void setPro_comment(String pro_comment) {
		this.pro_comment = pro_comment;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public ProductCommentDTO(String prd_no, String mem_id, String pro_comment, String writedate) {
		super();
		this.prd_no = prd_no;
		this.mem_id = mem_id;
		this.pro_comment = pro_comment;
		this.writedate = writedate;
	}
	
	
}
