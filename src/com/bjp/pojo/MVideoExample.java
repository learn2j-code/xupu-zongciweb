package com.bjp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MVideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MVideoExample() {
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

        public Criteria andVideoTitleIsNull() {
            addCriterion("video_title is null");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIsNotNull() {
            addCriterion("video_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideoTitleEqualTo(String value) {
            addCriterion("video_title =", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotEqualTo(String value) {
            addCriterion("video_title <>", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleGreaterThan(String value) {
            addCriterion("video_title >", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("video_title >=", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLessThan(String value) {
            addCriterion("video_title <", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLessThanOrEqualTo(String value) {
            addCriterion("video_title <=", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLike(String value) {
            addCriterion("video_title like", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotLike(String value) {
            addCriterion("video_title not like", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIn(List<String> values) {
            addCriterion("video_title in", values, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotIn(List<String> values) {
            addCriterion("video_title not in", values, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleBetween(String value1, String value2) {
            addCriterion("video_title between", value1, value2, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotBetween(String value1, String value2) {
            addCriterion("video_title not between", value1, value2, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andVideoAddressIsNull() {
            addCriterion("video_address is null");
            return (Criteria) this;
        }

        public Criteria andVideoAddressIsNotNull() {
            addCriterion("video_address is not null");
            return (Criteria) this;
        }

        public Criteria andVideoAddressEqualTo(String value) {
            addCriterion("video_address =", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotEqualTo(String value) {
            addCriterion("video_address <>", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressGreaterThan(String value) {
            addCriterion("video_address >", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("video_address >=", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressLessThan(String value) {
            addCriterion("video_address <", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressLessThanOrEqualTo(String value) {
            addCriterion("video_address <=", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressLike(String value) {
            addCriterion("video_address like", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotLike(String value) {
            addCriterion("video_address not like", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressIn(List<String> values) {
            addCriterion("video_address in", values, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotIn(List<String> values) {
            addCriterion("video_address not in", values, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressBetween(String value1, String value2) {
            addCriterion("video_address between", value1, value2, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotBetween(String value1, String value2) {
            addCriterion("video_address not between", value1, value2, "videoAddress");
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

        public Criteria andVideoIntroIsNull() {
            addCriterion("video_intro is null");
            return (Criteria) this;
        }

        public Criteria andVideoIntroIsNotNull() {
            addCriterion("video_intro is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIntroEqualTo(String value) {
            addCriterion("video_intro =", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroNotEqualTo(String value) {
            addCriterion("video_intro <>", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroGreaterThan(String value) {
            addCriterion("video_intro >", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroGreaterThanOrEqualTo(String value) {
            addCriterion("video_intro >=", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroLessThan(String value) {
            addCriterion("video_intro <", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroLessThanOrEqualTo(String value) {
            addCriterion("video_intro <=", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroLike(String value) {
            addCriterion("video_intro like", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroNotLike(String value) {
            addCriterion("video_intro not like", value, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroIn(List<String> values) {
            addCriterion("video_intro in", values, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroNotIn(List<String> values) {
            addCriterion("video_intro not in", values, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroBetween(String value1, String value2) {
            addCriterion("video_intro between", value1, value2, "videoIntro");
            return (Criteria) this;
        }

        public Criteria andVideoIntroNotBetween(String value1, String value2) {
            addCriterion("video_intro not between", value1, value2, "videoIntro");
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