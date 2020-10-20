package com.bjp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BbsArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BbsArticleExample() {
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

        public Criteria andBbsTitleIsNull() {
            addCriterion("bbs_title is null");
            return (Criteria) this;
        }

        public Criteria andBbsTitleIsNotNull() {
            addCriterion("bbs_title is not null");
            return (Criteria) this;
        }

        public Criteria andBbsTitleEqualTo(String value) {
            addCriterion("bbs_title =", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleNotEqualTo(String value) {
            addCriterion("bbs_title <>", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleGreaterThan(String value) {
            addCriterion("bbs_title >", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bbs_title >=", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleLessThan(String value) {
            addCriterion("bbs_title <", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleLessThanOrEqualTo(String value) {
            addCriterion("bbs_title <=", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleLike(String value) {
            addCriterion("bbs_title like", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleNotLike(String value) {
            addCriterion("bbs_title not like", value, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleIn(List<String> values) {
            addCriterion("bbs_title in", values, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleNotIn(List<String> values) {
            addCriterion("bbs_title not in", values, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleBetween(String value1, String value2) {
            addCriterion("bbs_title between", value1, value2, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andBbsTitleNotBetween(String value1, String value2) {
            addCriterion("bbs_title not between", value1, value2, "bbsTitle");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andStickFlagIsNull() {
            addCriterion("stick_flag is null");
            return (Criteria) this;
        }

        public Criteria andStickFlagIsNotNull() {
            addCriterion("stick_flag is not null");
            return (Criteria) this;
        }

        public Criteria andStickFlagEqualTo(Integer value) {
            addCriterion("stick_flag =", value, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagNotEqualTo(Integer value) {
            addCriterion("stick_flag <>", value, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagGreaterThan(Integer value) {
            addCriterion("stick_flag >", value, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("stick_flag >=", value, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagLessThan(Integer value) {
            addCriterion("stick_flag <", value, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagLessThanOrEqualTo(Integer value) {
            addCriterion("stick_flag <=", value, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagIn(List<Integer> values) {
            addCriterion("stick_flag in", values, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagNotIn(List<Integer> values) {
            addCriterion("stick_flag not in", values, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagBetween(Integer value1, Integer value2) {
            addCriterion("stick_flag between", value1, value2, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andStickFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("stick_flag not between", value1, value2, "stickFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagIsNull() {
            addCriterion("best_flag is null");
            return (Criteria) this;
        }

        public Criteria andBestFlagIsNotNull() {
            addCriterion("best_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBestFlagEqualTo(Integer value) {
            addCriterion("best_flag =", value, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagNotEqualTo(Integer value) {
            addCriterion("best_flag <>", value, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagGreaterThan(Integer value) {
            addCriterion("best_flag >", value, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("best_flag >=", value, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagLessThan(Integer value) {
            addCriterion("best_flag <", value, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagLessThanOrEqualTo(Integer value) {
            addCriterion("best_flag <=", value, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagIn(List<Integer> values) {
            addCriterion("best_flag in", values, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagNotIn(List<Integer> values) {
            addCriterion("best_flag not in", values, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagBetween(Integer value1, Integer value2) {
            addCriterion("best_flag between", value1, value2, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andBestFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("best_flag not between", value1, value2, "bestFlag");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andNymFlagIsNull() {
            addCriterion("nym_flag is null");
            return (Criteria) this;
        }

        public Criteria andNymFlagIsNotNull() {
            addCriterion("nym_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNymFlagEqualTo(Integer value) {
            addCriterion("nym_flag =", value, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagNotEqualTo(Integer value) {
            addCriterion("nym_flag <>", value, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagGreaterThan(Integer value) {
            addCriterion("nym_flag >", value, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("nym_flag >=", value, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagLessThan(Integer value) {
            addCriterion("nym_flag <", value, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagLessThanOrEqualTo(Integer value) {
            addCriterion("nym_flag <=", value, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagIn(List<Integer> values) {
            addCriterion("nym_flag in", values, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagNotIn(List<Integer> values) {
            addCriterion("nym_flag not in", values, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagBetween(Integer value1, Integer value2) {
            addCriterion("nym_flag between", value1, value2, "nymFlag");
            return (Criteria) this;
        }

        public Criteria andNymFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("nym_flag not between", value1, value2, "nymFlag");
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

        public Criteria andViewNumIsNull() {
            addCriterion("view_num is null");
            return (Criteria) this;
        }

        public Criteria andViewNumIsNotNull() {
            addCriterion("view_num is not null");
            return (Criteria) this;
        }

        public Criteria andViewNumEqualTo(Integer value) {
            addCriterion("view_num =", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotEqualTo(Integer value) {
            addCriterion("view_num <>", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThan(Integer value) {
            addCriterion("view_num >", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_num >=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThan(Integer value) {
            addCriterion("view_num <", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThanOrEqualTo(Integer value) {
            addCriterion("view_num <=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumIn(List<Integer> values) {
            addCriterion("view_num in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotIn(List<Integer> values) {
            addCriterion("view_num not in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumBetween(Integer value1, Integer value2) {
            addCriterion("view_num between", value1, value2, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotBetween(Integer value1, Integer value2) {
            addCriterion("view_num not between", value1, value2, "viewNum");
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