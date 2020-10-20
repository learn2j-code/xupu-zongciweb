package com.bjp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SClanHallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SClanHallExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallIsNull() {
            addCriterion("name_of_a_hall is null");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallIsNotNull() {
            addCriterion("name_of_a_hall is not null");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallEqualTo(String value) {
            addCriterion("name_of_a_hall =", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallNotEqualTo(String value) {
            addCriterion("name_of_a_hall <>", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallGreaterThan(String value) {
            addCriterion("name_of_a_hall >", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallGreaterThanOrEqualTo(String value) {
            addCriterion("name_of_a_hall >=", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallLessThan(String value) {
            addCriterion("name_of_a_hall <", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallLessThanOrEqualTo(String value) {
            addCriterion("name_of_a_hall <=", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallLike(String value) {
            addCriterion("name_of_a_hall like", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallNotLike(String value) {
            addCriterion("name_of_a_hall not like", value, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallIn(List<String> values) {
            addCriterion("name_of_a_hall in", values, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallNotIn(List<String> values) {
            addCriterion("name_of_a_hall not in", values, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallBetween(String value1, String value2) {
            addCriterion("name_of_a_hall between", value1, value2, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andNameOfAHallNotBetween(String value1, String value2) {
            addCriterion("name_of_a_hall not between", value1, value2, "nameOfAHall");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andFulladdressIsNull() {
            addCriterion("fulladdress is null");
            return (Criteria) this;
        }

        public Criteria andFulladdressIsNotNull() {
            addCriterion("fulladdress is not null");
            return (Criteria) this;
        }

        public Criteria andFulladdressEqualTo(String value) {
            addCriterion("fulladdress =", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressNotEqualTo(String value) {
            addCriterion("fulladdress <>", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressGreaterThan(String value) {
            addCriterion("fulladdress >", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressGreaterThanOrEqualTo(String value) {
            addCriterion("fulladdress >=", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressLessThan(String value) {
            addCriterion("fulladdress <", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressLessThanOrEqualTo(String value) {
            addCriterion("fulladdress <=", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressLike(String value) {
            addCriterion("fulladdress like", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressNotLike(String value) {
            addCriterion("fulladdress not like", value, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressIn(List<String> values) {
            addCriterion("fulladdress in", values, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressNotIn(List<String> values) {
            addCriterion("fulladdress not in", values, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressBetween(String value1, String value2) {
            addCriterion("fulladdress between", value1, value2, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andFulladdressNotBetween(String value1, String value2) {
            addCriterion("fulladdress not between", value1, value2, "fulladdress");
            return (Criteria) this;
        }

        public Criteria andCoordinateIsNull() {
            addCriterion("coordinate is null");
            return (Criteria) this;
        }

        public Criteria andCoordinateIsNotNull() {
            addCriterion("coordinate is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinateEqualTo(String value) {
            addCriterion("coordinate =", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotEqualTo(String value) {
            addCriterion("coordinate <>", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateGreaterThan(String value) {
            addCriterion("coordinate >", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateGreaterThanOrEqualTo(String value) {
            addCriterion("coordinate >=", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateLessThan(String value) {
            addCriterion("coordinate <", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateLessThanOrEqualTo(String value) {
            addCriterion("coordinate <=", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateLike(String value) {
            addCriterion("coordinate like", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotLike(String value) {
            addCriterion("coordinate not like", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateIn(List<String> values) {
            addCriterion("coordinate in", values, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotIn(List<String> values) {
            addCriterion("coordinate not in", values, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateBetween(String value1, String value2) {
            addCriterion("coordinate between", value1, value2, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotBetween(String value1, String value2) {
            addCriterion("coordinate not between", value1, value2, "coordinate");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andSynopsisIsNull() {
            addCriterion("synopsis is null");
            return (Criteria) this;
        }

        public Criteria andSynopsisIsNotNull() {
            addCriterion("synopsis is not null");
            return (Criteria) this;
        }

        public Criteria andSynopsisEqualTo(String value) {
            addCriterion("synopsis =", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotEqualTo(String value) {
            addCriterion("synopsis <>", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisGreaterThan(String value) {
            addCriterion("synopsis >", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisGreaterThanOrEqualTo(String value) {
            addCriterion("synopsis >=", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisLessThan(String value) {
            addCriterion("synopsis <", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisLessThanOrEqualTo(String value) {
            addCriterion("synopsis <=", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisLike(String value) {
            addCriterion("synopsis like", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotLike(String value) {
            addCriterion("synopsis not like", value, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisIn(List<String> values) {
            addCriterion("synopsis in", values, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotIn(List<String> values) {
            addCriterion("synopsis not in", values, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisBetween(String value1, String value2) {
            addCriterion("synopsis between", value1, value2, "synopsis");
            return (Criteria) this;
        }

        public Criteria andSynopsisNotBetween(String value1, String value2) {
            addCriterion("synopsis not between", value1, value2, "synopsis");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Integer value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Integer value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Integer value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Integer value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Integer> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Integer> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Integer value1, Integer value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelFlgIsNull() {
            addCriterion("del_flg is null");
            return (Criteria) this;
        }

        public Criteria andDelFlgIsNotNull() {
            addCriterion("del_flg is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlgEqualTo(Integer value) {
            addCriterion("del_flg =", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotEqualTo(Integer value) {
            addCriterion("del_flg <>", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgGreaterThan(Integer value) {
            addCriterion("del_flg >", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flg >=", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLessThan(Integer value) {
            addCriterion("del_flg <", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgLessThanOrEqualTo(Integer value) {
            addCriterion("del_flg <=", value, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgIn(List<Integer> values) {
            addCriterion("del_flg in", values, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotIn(List<Integer> values) {
            addCriterion("del_flg not in", values, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgBetween(Integer value1, Integer value2) {
            addCriterion("del_flg between", value1, value2, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDelFlgNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flg not between", value1, value2, "delFlg");
            return (Criteria) this;
        }

        public Criteria andDef1IsNull() {
            addCriterion("def1 is null");
            return (Criteria) this;
        }

        public Criteria andDef1IsNotNull() {
            addCriterion("def1 is not null");
            return (Criteria) this;
        }

        public Criteria andDef1EqualTo(String value) {
            addCriterion("def1 =", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1NotEqualTo(String value) {
            addCriterion("def1 <>", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1GreaterThan(String value) {
            addCriterion("def1 >", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1GreaterThanOrEqualTo(String value) {
            addCriterion("def1 >=", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1LessThan(String value) {
            addCriterion("def1 <", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1LessThanOrEqualTo(String value) {
            addCriterion("def1 <=", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1Like(String value) {
            addCriterion("def1 like", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1NotLike(String value) {
            addCriterion("def1 not like", value, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1In(List<String> values) {
            addCriterion("def1 in", values, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1NotIn(List<String> values) {
            addCriterion("def1 not in", values, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1Between(String value1, String value2) {
            addCriterion("def1 between", value1, value2, "def1");
            return (Criteria) this;
        }

        public Criteria andDef1NotBetween(String value1, String value2) {
            addCriterion("def1 not between", value1, value2, "def1");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andCoverImageIsNull() {
            addCriterion("cover_image is null");
            return (Criteria) this;
        }

        public Criteria andCoverImageIsNotNull() {
            addCriterion("cover_image is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImageEqualTo(String value) {
            addCriterion("cover_image =", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotEqualTo(String value) {
            addCriterion("cover_image <>", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageGreaterThan(String value) {
            addCriterion("cover_image >", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageGreaterThanOrEqualTo(String value) {
            addCriterion("cover_image >=", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLessThan(String value) {
            addCriterion("cover_image <", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLessThanOrEqualTo(String value) {
            addCriterion("cover_image <=", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLike(String value) {
            addCriterion("cover_image like", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotLike(String value) {
            addCriterion("cover_image not like", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageIn(List<String> values) {
            addCriterion("cover_image in", values, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotIn(List<String> values) {
            addCriterion("cover_image not in", values, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageBetween(String value1, String value2) {
            addCriterion("cover_image between", value1, value2, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotBetween(String value1, String value2) {
            addCriterion("cover_image not between", value1, value2, "coverImage");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagIsNull() {
            addCriterion("protected_flag is null");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagIsNotNull() {
            addCriterion("protected_flag is not null");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagEqualTo(Integer value) {
            addCriterion("protected_flag =", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagNotEqualTo(Integer value) {
            addCriterion("protected_flag <>", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagGreaterThan(Integer value) {
            addCriterion("protected_flag >", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("protected_flag >=", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagLessThan(Integer value) {
            addCriterion("protected_flag <", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagLessThanOrEqualTo(Integer value) {
            addCriterion("protected_flag <=", value, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagIn(List<Integer> values) {
            addCriterion("protected_flag in", values, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagNotIn(List<Integer> values) {
            addCriterion("protected_flag not in", values, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagBetween(Integer value1, Integer value2) {
            addCriterion("protected_flag between", value1, value2, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andProtectedFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("protected_flag not between", value1, value2, "protectedFlag");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbIsNull() {
            addCriterion("cover_image_thumb is null");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbIsNotNull() {
            addCriterion("cover_image_thumb is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbEqualTo(String value) {
            addCriterion("cover_image_thumb =", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbNotEqualTo(String value) {
            addCriterion("cover_image_thumb <>", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbGreaterThan(String value) {
            addCriterion("cover_image_thumb >", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbGreaterThanOrEqualTo(String value) {
            addCriterion("cover_image_thumb >=", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbLessThan(String value) {
            addCriterion("cover_image_thumb <", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbLessThanOrEqualTo(String value) {
            addCriterion("cover_image_thumb <=", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbLike(String value) {
            addCriterion("cover_image_thumb like", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbNotLike(String value) {
            addCriterion("cover_image_thumb not like", value, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbIn(List<String> values) {
            addCriterion("cover_image_thumb in", values, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbNotIn(List<String> values) {
            addCriterion("cover_image_thumb not in", values, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbBetween(String value1, String value2) {
            addCriterion("cover_image_thumb between", value1, value2, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andCoverImageThumbNotBetween(String value1, String value2) {
            addCriterion("cover_image_thumb not between", value1, value2, "coverImageThumb");
            return (Criteria) this;
        }

        public Criteria andDef2IsNull() {
            addCriterion("def2 is null");
            return (Criteria) this;
        }

        public Criteria andDef2IsNotNull() {
            addCriterion("def2 is not null");
            return (Criteria) this;
        }

        public Criteria andDef2EqualTo(String value) {
            addCriterion("def2 =", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2NotEqualTo(String value) {
            addCriterion("def2 <>", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2GreaterThan(String value) {
            addCriterion("def2 >", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2GreaterThanOrEqualTo(String value) {
            addCriterion("def2 >=", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2LessThan(String value) {
            addCriterion("def2 <", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2LessThanOrEqualTo(String value) {
            addCriterion("def2 <=", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2Like(String value) {
            addCriterion("def2 like", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2NotLike(String value) {
            addCriterion("def2 not like", value, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2In(List<String> values) {
            addCriterion("def2 in", values, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2NotIn(List<String> values) {
            addCriterion("def2 not in", values, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2Between(String value1, String value2) {
            addCriterion("def2 between", value1, value2, "def2");
            return (Criteria) this;
        }

        public Criteria andDef2NotBetween(String value1, String value2) {
            addCriterion("def2 not between", value1, value2, "def2");
            return (Criteria) this;
        }

        public Criteria andSurnameIsNull() {
            addCriterion("surname is null");
            return (Criteria) this;
        }

        public Criteria andSurnameIsNotNull() {
            addCriterion("surname is not null");
            return (Criteria) this;
        }

        public Criteria andSurnameEqualTo(String value) {
            addCriterion("surname =", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotEqualTo(String value) {
            addCriterion("surname <>", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameGreaterThan(String value) {
            addCriterion("surname >", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameGreaterThanOrEqualTo(String value) {
            addCriterion("surname >=", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameLessThan(String value) {
            addCriterion("surname <", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameLessThanOrEqualTo(String value) {
            addCriterion("surname <=", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameLike(String value) {
            addCriterion("surname like", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotLike(String value) {
            addCriterion("surname not like", value, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameIn(List<String> values) {
            addCriterion("surname in", values, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotIn(List<String> values) {
            addCriterion("surname not in", values, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameBetween(String value1, String value2) {
            addCriterion("surname between", value1, value2, "surname");
            return (Criteria) this;
        }

        public Criteria andSurnameNotBetween(String value1, String value2) {
            addCriterion("surname not between", value1, value2, "surname");
            return (Criteria) this;
        }

        public Criteria andReviewIsNull() {
            addCriterion("review is null");
            return (Criteria) this;
        }

        public Criteria andReviewIsNotNull() {
            addCriterion("review is not null");
            return (Criteria) this;
        }

        public Criteria andReviewEqualTo(Integer value) {
            addCriterion("review =", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotEqualTo(Integer value) {
            addCriterion("review <>", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewGreaterThan(Integer value) {
            addCriterion("review >", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("review >=", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewLessThan(Integer value) {
            addCriterion("review <", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewLessThanOrEqualTo(Integer value) {
            addCriterion("review <=", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewIn(List<Integer> values) {
            addCriterion("review in", values, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotIn(List<Integer> values) {
            addCriterion("review not in", values, "review");
            return (Criteria) this;
        }

        public Criteria andReviewBetween(Integer value1, Integer value2) {
            addCriterion("review between", value1, value2, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotBetween(Integer value1, Integer value2) {
            addCriterion("review not between", value1, value2, "review");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}