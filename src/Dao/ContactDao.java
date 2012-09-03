package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Contact;
import Entity.Contactnote;
import Util.DBhelp;
import Util.RowMapper;

public class ContactDao {

	private DBhelp<Contact> db = new DBhelp<Contact>();
	private DBhelp<Contactnote> notedb = new DBhelp<Contactnote>(); 
	public List<Contact> findAllContact(String projectid){
		String sql = "select * from t_contact where projectid = ?";
		return db.executeQueryForList(sql, new ContactRowMapper(), projectid);
	}
	public void saveContact(Contact con){
		String sql = "insert into t_contact(id,name,company,tele,homeTelt,email,address,zhuye,weibo,jianjie,projectid,weibohouzhui)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		db.executeSQL(sql, con.getId(),con.getName(),con.getCompany(),con.getTele(),con.getHomeTelt(),con.getEmail(),con.getAddress(),con.getZhuye(),con.getWeibo(),con.getJianjie(),con.getProjectid(),con.getWeibohouzhui());
	}
	public Contact findByContactid(String contactid){
		String sql = "select id,name,company,tele,homeTelt,email,address,zhuye,weibo,jianjie,projectid,weibohouzhui from t_contact where id = ?";
		return db.executeQueryForObject(sql, new ContactRowMapper(), contactid);
	}
	public void updateContact(Contact con){
		String sql ="update t_contact set name='?',company='?',tele='?',homeTelt='?',email='?',address='?',zhuye='?',weibo='?',jianjie='?',projectid='?',weibohouzhui='?' where id=?";
		db.executeSQL(sql, con.getName(),con.getCompany(),con.getTele(),con.getHomeTelt(),con.getEmail(),con.getAddress(),con.getZhuye(),con.getWeibo(),con.getJianjie(),con.getProjectid(),con.getWeibohouzhui(),con.getId());
	}
	public void deleteContact(String contactid){
		String sql = "delete from t_contact where id = ?";
		db.executeSQL(sql, contactid);
	}
	private class ContactRowMapper implements RowMapper<Contact>{

		public Contact mapperRow(ResultSet rs) throws SQLException {
			Contact con = new Contact();
			con.setAddress(rs.getString("address"));
			con.setCompany(rs.getString("company"));
			con.setEmail(rs.getString("email"));
			con.setHomeTelt(rs.getString("homeTelt"));
			con.setId(rs.getString("id"));
			con.setJianjie(rs.getString("jianjie"));
			con.setName(rs.getString("name"));
			con.setProjectid(rs.getString("projectid"));
			con.setTele(rs.getString("tele"));
			con.setWeibo(rs.getString("weibo"));
			con.setWeibohouzhui(rs.getString("weibohouzhui"));
			con.setZhuye(rs.getString("zhuye"));
			return con;
		}
	}
	private class ContactnoteRowMapper implements RowMapper<Contactnote>{
		public Contactnote mapperRow(ResultSet rs) throws SQLException{
			Contactnote note = new Contactnote();
			note.setContactid(rs.getString("contactid"));
			note.setCreatetime(rs.getString("createtime"));
			note.setId(rs.getString("id"));
			note.setNeiRong(rs.getString("neiRong"));
			note.setUserid(rs.getString("userid"));
			return note;
		}
		
	}
	
	
	public void saveNote(Contactnote note) {
		String sql = "insert into t_contactnote(id,contactid,createtime,neiRong,userid)values(?,?,?,?,?)";
		db.executeSQL(sql, note.getId(),note.getContactid(),note.getCreatetime(),note.getNeiRong(),note.getUserid());
	}
	public List<Contactnote> findAllNote() {
		String sql = "select * from t_contactnote";
		return notedb.executeQueryForList(sql, new ContactnoteRowMapper());
	}
	
	
}
