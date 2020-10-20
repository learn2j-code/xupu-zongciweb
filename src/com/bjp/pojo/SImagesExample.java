package com.bjp.pojo;

import java.util.ArrayList;
import java.util.List;

public class SImagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SImagesExample() {
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

        public Criteria andClanIdIsNull() {
            addCriterion("clan_id is null");
            return (Criteria) this;
        }

        public Criteria andClanIdIsNotNull() {
            addCriterion("clan_id is not null");
            return (Criteria) this;
        }

        public Criteria andClanIdEqualTo(Integer value) {
            addCriterion("clan_id =", value, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdNotEqualTo(Integer value) {
            addCriterion("clan_id <>", value, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdGreaterThan(Integer value) {
            addCriterion("clan_id >", value, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("clan_id >=", value, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdLessThan(Integer value) {
            addCriterion("clan_id <", value, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdLessThanOrEqualTo(Integer value) {
            addCriterion("clan_id <=", value, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdIn(List<Integer> values) {
            addCriterion("clan_id in", values, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdNotIn(List<Integer> values) {
            addCriterion("clan_id not in", values, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdBetween(Integer value1, Integer value2) {
            addCriterion("clan_id between", value1, value2, "clanId");
            return (Criteria) this;
        }

        public Criteria andClanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("clan_id not between", value1, value2, "clanId");
            return (Criteria) this;
        }

        public Criteria andCompositorIsNull() {
            addCriterion("compositor is null");
            return (Criteria) this;
        }

        public Criteria andCompositorIsNotNull() {
            addCriterion("compositor is not null");
            return (Criteria) this;
        }

        public Criteria andCompositorEqualTo(Integer value) {
            addCriterion("compositor =", value, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorNotEqualTo(Integer value) {
            addCriterion("compositor <>", value, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorGreaterThan(Integer value) {
            addCriterion("compositor >", value, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorGreaterThanOrEqualTo(Integer value) {
            addCriterion("compositor >=", value, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorLessThan(Integer value) {
            addCriterion("compositor <", value, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorLessThanOrEqualTo(Integer value) {
            addCriterion("compositor <=", value, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorIn(List<Integer> values) {
            addCriterion("compositor in", values, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorNotIn(List<Integer> values) {
            addCriterion("compositor not in", values, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorBetween(Integer value1, Integer value2) {
            addCriterion("compositor between", value1, value2, "compositor");
            return (Criteria) this;
        }

        public Criteria andCompositorNotBetween(Integer value1, Integer value2) {
            addCriterion("compositor not between", value1, value2, "compositor");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlIsNull() {
            addCriterion("image_ftpurl is null");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlIsNotNull() {
            addCriterion("image_ftpurl is not null");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlEqualTo(String value) {
            addCriterion("image_ftpurl =", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlNotEqualTo(String value) {
            addCriterion("image_ftpurl <>", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlGreaterThan(String value) {
            addCriterion("image_ftpurl >", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlGreaterThanOrEqualTo(String value) {
            addCriterion("image_ftpurl >=", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlLessThan(String value) {
            addCriterion("image_ftpurl <", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlLessThanOrEqualTo(String value) {
            addCriterion("image_ftpurl <=", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlLike(String value) {
            addCriterion("image_ftpurl like", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlNotLike(String value) {
            addCriterion("image_ftpurl not like", value, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlIn(List<String> values) {
            addCriterion("image_ftpurl in", values, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlNotIn(List<String> values) {
            addCriterion("image_ftpurl not in", values, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlBetween(String value1, String value2) {
            addCriterion("image_ftpurl between", value1, value2, "imageFtpurl");
            return (Criteria) this;
        }

        public Criteria andImageFtpurlNotBetween(String value1, String value2) {
            addCriterion("image_ftpurl not between", value1, value2, "imageFtpurl");
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