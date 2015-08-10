/*
 * This file is a part of thundr-contrib-jdbc, a software library from Atomic Leopard.
 *
 * Copyright (C) 2015 Atomic Leopard, <nick@atomicleopard.com.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atomicleopard.thundr.jooq;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.InvalidResultException;
import org.jooq.exception.TooManyRowsException;
import org.jooq.tools.jdbc.MockCallable;
import org.jooq.tools.jdbc.MockDataProvider;
import org.jooq.tools.jdbc.MockRunnable;

public class Jooq implements DSLContext {
	protected DSLContext delegate;

	public Jooq(DSLContext delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public Configuration configuration() {
		return delegate.configuration();
	}

	@Override
	public Settings settings() {
		return delegate.settings();
	}

	@Override
	public SQLDialect dialect() {
		return delegate.dialect();
	}

	@Override
	public SQLDialect family() {
		return delegate.family();
	}

	@Override
	public Map<Object, Object> data() {
		return delegate.data();
	}

	@Override
	public Object data(Object key) {
		return delegate.data(key);
	}

	@Override
	public Object data(Object key, Object value) {
		return delegate.data(key, value);
	}

	@Override
	public Schema map(Schema schema) {
		return delegate.map(schema);
	}

	@Override
	public <R extends Record> Table<R> map(Table<R> table) {
		return delegate.map(table);
	}

	@Override
	public Meta meta() {
		return delegate.meta();
	}

	@Override
	public <T> T transactionResult(TransactionalCallable<T> transactional) {
		return delegate.transactionResult(transactional);
	}

	@Override
	public void transaction(TransactionalRunnable transactional) {
		delegate.transaction(transactional);
	}

	@Override
	public <T> T mockResult(MockDataProvider provider, MockCallable<T> mockable) {
		return delegate.mockResult(provider, mockable);
	}

	@Override
	public void mock(MockDataProvider provider, MockRunnable mockable) {
		delegate.mock(provider, mockable);
	}

	@Override
	public RenderContext renderContext() {
		return delegate.renderContext();
	}

	@Override
	public String render(QueryPart part) {
		return delegate.render(part);
	}

	@Override
	public String renderNamedParams(QueryPart part) {
		return delegate.renderNamedParams(part);
	}

	@Override
	public String renderNamedOrInlinedParams(QueryPart part) {
		return delegate.renderNamedOrInlinedParams(part);
	}

	@Override
	public String renderInlined(QueryPart part) {
		return delegate.renderInlined(part);
	}

	@Override
	public List<Object> extractBindValues(QueryPart part) {
		return delegate.extractBindValues(part);
	}

	@Override
	public Map<String, Param<?>> extractParams(QueryPart part) {
		return delegate.extractParams(part);
	}

	@Override
	public Param<?> extractParam(QueryPart part, String name) {
		return delegate.extractParam(part, name);
	}

	@Override
	public BindContext bindContext(PreparedStatement stmt) {
		return delegate.bindContext(stmt);
	}

	@Override
	@Deprecated
	public int bind(QueryPart part, PreparedStatement stmt) {
		return delegate.bind(part, stmt);
	}

	@Override
	public void attach(Attachable... attachables) {
		delegate.attach(attachables);
	}

	@Override
	public void attach(Collection<? extends Attachable> attachables) {
		delegate.attach(attachables);
	}

	@Override
	public <R extends TableRecord<R>> LoaderOptionsStep<R> loadInto(Table<R> table) {
		return delegate.loadInto(table);
	}

	@Override
	public Query query(String sql) {
		return delegate.query(sql);
	}

	@Override
	public Query query(String sql, Object... bindings) {
		return delegate.query(sql, bindings);
	}

	@Override
	public Query query(String sql, QueryPart... parts) {
		return delegate.query(sql, parts);
	}

	@Override
	public Result<Record> fetch(String sql) throws DataAccessException {
		return delegate.fetch(sql);
	}

	@Override
	public Result<Record> fetch(String sql, Object... bindings) throws DataAccessException {
		return delegate.fetch(sql, bindings);
	}

	@Override
	public Result<Record> fetch(String sql, QueryPart... parts) throws DataAccessException {
		return delegate.fetch(sql, parts);
	}

	@Override
	public Cursor<Record> fetchLazy(String sql) throws DataAccessException {
		return delegate.fetchLazy(sql);
	}

	@Override
	public Cursor<Record> fetchLazy(String sql, Object... bindings) throws DataAccessException {
		return delegate.fetchLazy(sql, bindings);
	}

	@Override
	public Cursor<Record> fetchLazy(String sql, QueryPart... parts) throws DataAccessException {
		return delegate.fetchLazy(sql, parts);
	}

	@Override
	public List<Result<Record>> fetchMany(String sql) throws DataAccessException {
		return delegate.fetchMany(sql);
	}

	@Override
	public List<Result<Record>> fetchMany(String sql, Object... bindings) throws DataAccessException {
		return delegate.fetchMany(sql, bindings);
	}

	@Override
	public List<Result<Record>> fetchMany(String sql, QueryPart... parts) throws DataAccessException {
		return delegate.fetchMany(sql, parts);
	}

	@Override
	public Record fetchOne(String sql) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(sql);
	}

	@Override
	public Record fetchOne(String sql, Object... bindings) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(sql, bindings);
	}

	@Override
	public Record fetchOne(String sql, QueryPart... parts) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(sql, parts);
	}

	@Override
	public Object fetchValue(String sql) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(sql);
	}

	@Override
	public Object fetchValue(String sql, Object... bindings) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(sql, bindings);
	}

	@Override
	public Object fetchValue(String sql, QueryPart... parts) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(sql, parts);
	}

	@Override
	public List<?> fetchValues(String sql) throws DataAccessException {
		return delegate.fetchValues(sql);
	}

	@Override
	public List<?> fetchValues(String sql, Object... bindings) throws DataAccessException {
		return delegate.fetchValues(sql, bindings);
	}

	@Override
	public List<?> fetchValues(String sql, QueryPart... parts) throws DataAccessException {
		return delegate.fetchValues(sql, parts);
	}

	@Override
	public int execute(String sql) throws DataAccessException {
		return delegate.execute(sql);
	}

	@Override
	public int execute(String sql, Object... bindings) throws DataAccessException {
		return delegate.execute(sql, bindings);
	}

	@Override
	public int execute(String sql, QueryPart... parts) throws DataAccessException {
		return delegate.execute(sql, parts);
	}

	@Override
	public ResultQuery<Record> resultQuery(String sql) {
		return delegate.resultQuery(sql);
	}

	@Override
	public ResultQuery<Record> resultQuery(String sql, Object... bindings) {
		return delegate.resultQuery(sql, bindings);
	}

	@Override
	public ResultQuery<Record> resultQuery(String sql, QueryPart... parts) {
		return delegate.resultQuery(sql, parts);
	}

	@Override
	public Result<Record> fetch(ResultSet rs) throws DataAccessException {
		return delegate.fetch(rs);
	}

	@Override
	public Result<Record> fetch(ResultSet rs, Field<?>... fields) throws DataAccessException {
		return delegate.fetch(rs, fields);
	}

	@Override
	public Result<Record> fetch(ResultSet rs, DataType<?>... types) throws DataAccessException {
		return delegate.fetch(rs, types);
	}

	@Override
	public Result<Record> fetch(ResultSet rs, Class<?>... types) throws DataAccessException {
		return delegate.fetch(rs, types);
	}

	@Override
	public Record fetchOne(ResultSet rs) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(rs);
	}

	@Override
	public Record fetchOne(ResultSet rs, Field<?>... fields) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(rs, fields);
	}

	@Override
	public Record fetchOne(ResultSet rs, DataType<?>... types) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(rs, types);
	}

	@Override
	public Record fetchOne(ResultSet rs, Class<?>... types) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(rs, types);
	}

	@Override
	public Object fetchValue(ResultSet rs) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(rs);
	}

	@Override
	public <T> T fetchValue(ResultSet rs, Field<T> field) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(rs, field);
	}

	@Override
	public <T> T fetchValue(ResultSet rs, DataType<T> type) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(rs, type);
	}

	@Override
	public <T> T fetchValue(ResultSet rs, Class<T> type) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(rs, type);
	}

	@Override
	public List<?> fetchValues(ResultSet rs) throws DataAccessException {
		return delegate.fetchValues(rs);
	}

	@Override
	public <T> List<T> fetchValues(ResultSet rs, Field<T> field) throws DataAccessException {
		return delegate.fetchValues(rs, field);
	}

	@Override
	public <T> List<T> fetchValues(ResultSet rs, DataType<T> type) throws DataAccessException {
		return delegate.fetchValues(rs, type);
	}

	@Override
	public <T> List<T> fetchValues(ResultSet rs, Class<T> type) throws DataAccessException {
		return delegate.fetchValues(rs, type);
	}

	@Override
	public Cursor<Record> fetchLazy(ResultSet rs) throws DataAccessException {
		return delegate.fetchLazy(rs);
	}

	@Override
	public Cursor<Record> fetchLazy(ResultSet rs, Field<?>... fields) throws DataAccessException {
		return delegate.fetchLazy(rs, fields);
	}

	@Override
	public Cursor<Record> fetchLazy(ResultSet rs, DataType<?>... types) throws DataAccessException {
		return delegate.fetchLazy(rs, types);
	}

	@Override
	public Cursor<Record> fetchLazy(ResultSet rs, Class<?>... types) throws DataAccessException {
		return delegate.fetchLazy(rs, types);
	}

	@Override
	public Result<Record> fetchFromTXT(String string) throws DataAccessException {
		return delegate.fetchFromTXT(string);
	}

	@Override
	public Result<Record> fetchFromTXT(String string, String nullLiteral) throws DataAccessException {
		return delegate.fetchFromTXT(string, nullLiteral);
	}

	@Override
	public Result<Record> fetchFromCSV(String string) throws DataAccessException {
		return delegate.fetchFromCSV(string);
	}

	@Override
	public Result<Record> fetchFromCSV(String string, char delimiter) throws DataAccessException {
		return delegate.fetchFromCSV(string, delimiter);
	}

	@Override
	public Result<Record> fetchFromJSON(String string) {
		return delegate.fetchFromJSON(string);
	}

	@Override
	public Result<Record> fetchFromStringData(String[]... data) {
		return delegate.fetchFromStringData(data);
	}

	@Override
	public Result<Record> fetchFromStringData(List<String[]> data) {
		return delegate.fetchFromStringData(data);
	}

	@Override
	public WithAsStep with(String alias) {
		return delegate.with(alias);
	}

	@Override
	public WithAsStep with(String alias, String... fieldAliases) {
		return delegate.with(alias, fieldAliases);
	}

	@Override
	public WithStep with(CommonTableExpression<?>... tables) {
		return delegate.with(tables);
	}

	@Override
	public WithAsStep withRecursive(String alias) {
		return delegate.withRecursive(alias);
	}

	@Override
	public WithAsStep withRecursive(String alias, String... fieldAliases) {
		return delegate.withRecursive(alias, fieldAliases);
	}

	@Override
	public WithStep withRecursive(CommonTableExpression<?>... tables) {
		return delegate.withRecursive(tables);
	}

	@Override
	public <R extends Record> SelectWhereStep<R> selectFrom(Table<R> table) {
		return delegate.selectFrom(table);
	}

	@Override
	public SelectSelectStep<Record> select(Collection<? extends SelectField<?>> fields) {
		return delegate.select(fields);
	}

	@Override
	public SelectSelectStep<Record> select(SelectField<?>... fields) {
		return delegate.select(fields);
	}

	@Override
	public <T1> SelectSelectStep<Record1<T1>> select(SelectField<T1> field1) {
		return delegate.select(field1);
	}

	@Override
	public <T1, T2> SelectSelectStep<Record2<T1, T2>> select(SelectField<T1> field1, SelectField<T2> field2) {
		return delegate.select(field1, field2);
	}

	@Override
	public <T1, T2, T3> SelectSelectStep<Record3<T1, T2, T3>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3) {
		return delegate.select(field1, field2, field3);
	}

	@Override
	public <T1, T2, T3, T4> SelectSelectStep<Record4<T1, T2, T3, T4>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4) {
		return delegate.select(field1, field2, field3, field4);
	}

	@Override
	public <T1, T2, T3, T4, T5> SelectSelectStep<Record5<T1, T2, T3, T4, T5>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4,
			SelectField<T5> field5) {
		return delegate.select(field1, field2, field3, field4, field5);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6> SelectSelectStep<Record6<T1, T2, T3, T4, T5, T6>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4,
			SelectField<T5> field5, SelectField<T6> field6) {
		return delegate.select(field1, field2, field3, field4, field5, field6);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7> SelectSelectStep<Record7<T1, T2, T3, T4, T5, T6, T7>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4,
			SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8> SelectSelectStep<Record8<T1, T2, T3, T4, T5, T6, T7, T8>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3,
			SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectSelectStep<Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3,
			SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectSelectStep<Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> select(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3,
			SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectSelectStep<Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> select(SelectField<T1> field1, SelectField<T2> field2,
			SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9,
			SelectField<T10> field10, SelectField<T11> field11) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectSelectStep<Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> select(SelectField<T1> field1, SelectField<T2> field2,
			SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9,
			SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectSelectStep<Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> select(SelectField<T1> field1,
			SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8,
			SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectSelectStep<Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> select(SelectField<T1> field1,
			SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8,
			SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectSelectStep<Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectSelectStep<Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectSelectStep<Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectSelectStep<Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectSelectStep<Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectSelectStep<Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19, SelectField<T20> field20) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectSelectStep<Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19, SelectField<T20> field20, SelectField<T21> field21) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20, field21);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectSelectStep<Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> select(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19, SelectField<T20> field20, SelectField<T21> field21,
			SelectField<T22> field22) {
		return delegate.select(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20, field21, field22);
	}

	@Override
	public SelectSelectStep<Record> selectDistinct(Collection<? extends SelectField<?>> fields) {
		return delegate.selectDistinct(fields);
	}

	@Override
	public SelectSelectStep<Record> selectDistinct(SelectField<?>... fields) {
		return delegate.selectDistinct(fields);
	}

	@Override
	public <T1> SelectSelectStep<Record1<T1>> selectDistinct(SelectField<T1> field1) {
		return delegate.selectDistinct(field1);
	}

	@Override
	public <T1, T2> SelectSelectStep<Record2<T1, T2>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2) {
		return delegate.selectDistinct(field1, field2);
	}

	@Override
	public <T1, T2, T3> SelectSelectStep<Record3<T1, T2, T3>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3) {
		return delegate.selectDistinct(field1, field2, field3);
	}

	@Override
	public <T1, T2, T3, T4> SelectSelectStep<Record4<T1, T2, T3, T4>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4) {
		return delegate.selectDistinct(field1, field2, field3, field4);
	}

	@Override
	public <T1, T2, T3, T4, T5> SelectSelectStep<Record5<T1, T2, T3, T4, T5>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4,
			SelectField<T5> field5) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6> SelectSelectStep<Record6<T1, T2, T3, T4, T5, T6>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4,
			SelectField<T5> field5, SelectField<T6> field6) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7> SelectSelectStep<Record7<T1, T2, T3, T4, T5, T6, T7>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3,
			SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8> SelectSelectStep<Record8<T1, T2, T3, T4, T5, T6, T7, T8>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3,
			SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectSelectStep<Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3,
			SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectSelectStep<Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2,
			SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9,
			SelectField<T10> field10) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectSelectStep<Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> selectDistinct(SelectField<T1> field1, SelectField<T2> field2,
			SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8, SelectField<T9> field9,
			SelectField<T10> field10, SelectField<T11> field11) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectSelectStep<Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> selectDistinct(SelectField<T1> field1,
			SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8,
			SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectSelectStep<Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> selectDistinct(SelectField<T1> field1,
			SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8,
			SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectSelectStep<Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> selectDistinct(SelectField<T1> field1,
			SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7, SelectField<T8> field8,
			SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectSelectStep<Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectSelectStep<Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectSelectStep<Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectSelectStep<Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectSelectStep<Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19) {
		return delegate
				.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectSelectStep<Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19, SelectField<T20> field20) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectSelectStep<Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19, SelectField<T20> field20, SelectField<T21> field21) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20, field21);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectSelectStep<Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> selectDistinct(
			SelectField<T1> field1, SelectField<T2> field2, SelectField<T3> field3, SelectField<T4> field4, SelectField<T5> field5, SelectField<T6> field6, SelectField<T7> field7,
			SelectField<T8> field8, SelectField<T9> field9, SelectField<T10> field10, SelectField<T11> field11, SelectField<T12> field12, SelectField<T13> field13, SelectField<T14> field14,
			SelectField<T15> field15, SelectField<T16> field16, SelectField<T17> field17, SelectField<T18> field18, SelectField<T19> field19, SelectField<T20> field20, SelectField<T21> field21,
			SelectField<T22> field22) {
		return delegate.selectDistinct(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20, field21, field22);
	}

	@Override
	public SelectSelectStep<Record1<Integer>> selectZero() {
		return delegate.selectZero();
	}

	@Override
	public SelectSelectStep<Record1<Integer>> selectOne() {
		return delegate.selectOne();
	}

	@Override
	public SelectSelectStep<Record1<Integer>> selectCount() {
		return delegate.selectCount();
	}

	@Override
	public SelectQuery<Record> selectQuery() {
		return delegate.selectQuery();
	}

	@Override
	public <R extends Record> SelectQuery<R> selectQuery(TableLike<R> table) {
		return delegate.selectQuery(table);
	}

	@Override
	public <R extends Record> InsertQuery<R> insertQuery(Table<R> into) {
		return delegate.insertQuery(into);
	}

	@Override
	public <R extends Record> InsertSetStep<R> insertInto(Table<R> into) {
		return delegate.insertInto(into);
	}

	@Override
	public <R extends Record, T1> InsertValuesStep1<R, T1> insertInto(Table<R> into, Field<T1> field1) {
		return delegate.insertInto(into, field1);
	}

	@Override
	public <R extends Record, T1, T2> InsertValuesStep2<R, T1, T2> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2) {
		return delegate.insertInto(into, field1, field2);
	}

	@Override
	public <R extends Record, T1, T2, T3> InsertValuesStep3<R, T1, T2, T3> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3) {
		return delegate.insertInto(into, field1, field2, field3);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4> InsertValuesStep4<R, T1, T2, T3, T4> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4) {
		return delegate.insertInto(into, field1, field2, field3, field4);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5> InsertValuesStep5<R, T1, T2, T3, T4, T5> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6> InsertValuesStep6<R, T1, T2, T3, T4, T5, T6> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5, Field<T6> field6) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7> InsertValuesStep7<R, T1, T2, T3, T4, T5, T6, T7> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8> InsertValuesStep8<R, T1, T2, T3, T4, T5, T6, T7, T8> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9> InsertValuesStep9<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> InsertValuesStep10<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> insertInto(Table<R> into, Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> InsertValuesStep11<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> insertInto(Table<R> into, Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> InsertValuesStep12<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> insertInto(Table<R> into, Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11,
			Field<T12> field12) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> InsertValuesStep13<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> insertInto(Table<R> into,
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> InsertValuesStep14<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> insertInto(Table<R> into,
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> InsertValuesStep15<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> InsertValuesStep16<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> InsertValuesStep17<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> InsertValuesStep18<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> InsertValuesStep19<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> InsertValuesStep20<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19, Field<T20> field20) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> InsertValuesStep21<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19, Field<T20> field20, Field<T21> field21) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20, field21);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> InsertValuesStep22<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> insertInto(
			Table<R> into, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19, Field<T20> field20, Field<T21> field21, Field<T22> field22) {
		return delegate.insertInto(into, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20, field21, field22);
	}

	@Override
	public <R extends Record> InsertValuesStepN<R> insertInto(Table<R> into, Field<?>... fields) {
		return delegate.insertInto(into, fields);
	}

	@Override
	public <R extends Record> InsertValuesStepN<R> insertInto(Table<R> into, Collection<? extends Field<?>> fields) {
		return delegate.insertInto(into, fields);
	}

	@Override
	public <R extends Record> UpdateQuery<R> updateQuery(Table<R> table) {
		return delegate.updateQuery(table);
	}

	@Override
	public <R extends Record> UpdateSetFirstStep<R> update(Table<R> table) {
		return delegate.update(table);
	}

	@Override
	public <R extends Record> MergeUsingStep<R> mergeInto(Table<R> table) {
		return delegate.mergeInto(table);
	}

	@Override
	public <R extends Record, T1> MergeKeyStep1<R, T1> mergeInto(Table<R> table, Field<T1> field1) {
		return delegate.mergeInto(table, field1);
	}

	@Override
	public <R extends Record, T1, T2> MergeKeyStep2<R, T1, T2> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2) {
		return delegate.mergeInto(table, field1, field2);
	}

	@Override
	public <R extends Record, T1, T2, T3> MergeKeyStep3<R, T1, T2, T3> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3) {
		return delegate.mergeInto(table, field1, field2, field3);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4> MergeKeyStep4<R, T1, T2, T3, T4> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4) {
		return delegate.mergeInto(table, field1, field2, field3, field4);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5> MergeKeyStep5<R, T1, T2, T3, T4, T5> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6> MergeKeyStep6<R, T1, T2, T3, T4, T5, T6> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5, Field<T6> field6) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7> MergeKeyStep7<R, T1, T2, T3, T4, T5, T6, T7> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8> MergeKeyStep8<R, T1, T2, T3, T4, T5, T6, T7, T8> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9> MergeKeyStep9<R, T1, T2, T3, T4, T5, T6, T7, T8, T9> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> MergeKeyStep10<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> mergeInto(Table<R> table, Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> MergeKeyStep11<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> mergeInto(Table<R> table, Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> MergeKeyStep12<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> mergeInto(Table<R> table, Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11,
			Field<T12> field12) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> MergeKeyStep13<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> mergeInto(Table<R> table,
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> MergeKeyStep14<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> mergeInto(Table<R> table,
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> MergeKeyStep15<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> MergeKeyStep16<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> MergeKeyStep17<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> MergeKeyStep18<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> MergeKeyStep19<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> MergeKeyStep20<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19, Field<T20> field20) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> MergeKeyStep21<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19, Field<T20> field20, Field<T21> field21) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20, field21);
	}

	@Override
	public <R extends Record, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> MergeKeyStep22<R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> mergeInto(
			Table<R> table, Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9,
			Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18,
			Field<T19> field19, Field<T20> field20, Field<T21> field21, Field<T22> field22) {
		return delegate.mergeInto(table, field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18,
				field19, field20, field21, field22);
	}

	@Override
	public <R extends Record> MergeKeyStepN<R> mergeInto(Table<R> table, Field<?>... fields) {
		return delegate.mergeInto(table, fields);
	}

	@Override
	public <R extends Record> MergeKeyStepN<R> mergeInto(Table<R> table, Collection<? extends Field<?>> fields) {
		return delegate.mergeInto(table, fields);
	}

	@Override
	public <R extends Record> DeleteQuery<R> deleteQuery(Table<R> table) {
		return delegate.deleteQuery(table);
	}

	@Override
	public <R extends Record> DeleteWhereStep<R> deleteFrom(Table<R> table) {
		return delegate.deleteFrom(table);
	}

	@Override
	public <R extends Record> DeleteWhereStep<R> delete(Table<R> table) {
		return delegate.delete(table);
	}

	@Override
	public Batch batch(Query... queries) {
		return delegate.batch(queries);
	}

	@Override
	public Batch batch(String... queries) {
		return delegate.batch(queries);
	}

	@Override
	public Batch batch(Collection<? extends Query> queries) {
		return delegate.batch(queries);
	}

	@Override
	public BatchBindStep batch(Query query) {
		return delegate.batch(query);
	}

	@Override
	public BatchBindStep batch(String sql) {
		return delegate.batch(sql);
	}

	@Override
	public Batch batch(Query query, Object[]... bindings) {
		return delegate.batch(query, bindings);
	}

	@Override
	public Batch batch(String sql, Object[]... bindings) {
		return delegate.batch(sql, bindings);
	}

	@Override
	public Batch batchStore(UpdatableRecord<?>... records) {
		return delegate.batchStore(records);
	}

	@Override
	public Batch batchStore(Collection<? extends UpdatableRecord<?>> records) {
		return delegate.batchStore(records);
	}

	@Override
	public Batch batchInsert(TableRecord<?>... records) {
		return delegate.batchInsert(records);
	}

	@Override
	public Batch batchInsert(Collection<? extends TableRecord<?>> records) {
		return delegate.batchInsert(records);
	}

	@Override
	public Batch batchUpdate(UpdatableRecord<?>... records) {
		return delegate.batchUpdate(records);
	}

	@Override
	public Batch batchUpdate(Collection<? extends UpdatableRecord<?>> records) {
		return delegate.batchUpdate(records);
	}

	@Override
	public Batch batchDelete(UpdatableRecord<?>... records) {
		return delegate.batchDelete(records);
	}

	@Override
	public Batch batchDelete(Collection<? extends UpdatableRecord<?>> records) {
		return delegate.batchDelete(records);
	}

	@Override
	public CreateTableAsStep<Record> createTable(String table) {
		return delegate.createTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createTable(Name table) {
		return delegate.createTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createTable(Table<?> table) {
		return delegate.createTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createTemporaryTable(String table) {
		return delegate.createTemporaryTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createTemporaryTable(Name table) {
		return delegate.createTemporaryTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createTemporaryTable(Table<?> table) {
		return delegate.createTemporaryTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createGlobalTemporaryTable(String table) {
		return delegate.createGlobalTemporaryTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createGlobalTemporaryTable(Name table) {
		return delegate.createGlobalTemporaryTable(table);
	}

	@Override
	public CreateTableAsStep<Record> createGlobalTemporaryTable(Table<?> table) {
		return delegate.createGlobalTemporaryTable(table);
	}

	@Override
	public CreateViewAsStep<Record> createView(String view, String... fields) {
		return delegate.createView(view, fields);
	}

	@Override
	public CreateViewAsStep<Record> createView(Name view, Name... fields) {
		return delegate.createView(view, fields);
	}

	@Override
	public CreateViewAsStep<Record> createView(Table<?> view, Field<?>... fields) {
		return delegate.createView(view, fields);
	}

	@Override
	public CreateIndexStep createIndex(String index) {
		return delegate.createIndex(index);
	}

	@Override
	public CreateIndexStep createIndex(Name index) {
		return delegate.createIndex(index);
	}

	@Override
	public CreateSequenceFinalStep createSequence(String sequence) {
		return delegate.createSequence(sequence);
	}

	@Override
	public CreateSequenceFinalStep createSequence(Name sequence) {
		return delegate.createSequence(sequence);
	}

	@Override
	public CreateSequenceFinalStep createSequence(Sequence<?> sequence) {
		return delegate.createSequence(sequence);
	}

	@Override
	public AlterSequenceRestartStep<BigInteger> alterSequence(String sequence) {
		return delegate.alterSequence(sequence);
	}

	@Override
	public AlterSequenceRestartStep<BigInteger> alterSequence(Name sequence) {
		return delegate.alterSequence(sequence);
	}

	@Override
	public <T extends Number> AlterSequenceRestartStep<T> alterSequence(Sequence<T> sequence) {
		return delegate.alterSequence(sequence);
	}

	@Override
	public AlterTableStep alterTable(String table) {
		return delegate.alterTable(table);
	}

	@Override
	public AlterTableStep alterTable(Name table) {
		return delegate.alterTable(table);
	}

	@Override
	public AlterTableStep alterTable(Table<?> table) {
		return delegate.alterTable(table);
	}

	@Override
	public DropViewFinalStep dropView(String view) {
		return delegate.dropView(view);
	}

	@Override
	public DropViewFinalStep dropView(Name view) {
		return delegate.dropView(view);
	}

	@Override
	public DropViewFinalStep dropView(Table<?> view) {
		return delegate.dropView(view);
	}

	@Override
	public DropViewFinalStep dropViewIfExists(String view) {
		return delegate.dropViewIfExists(view);
	}

	@Override
	public DropViewFinalStep dropViewIfExists(Name view) {
		return delegate.dropViewIfExists(view);
	}

	@Override
	public DropViewFinalStep dropViewIfExists(Table<?> view) {
		return delegate.dropViewIfExists(view);
	}

	@Override
	public DropTableStep dropTable(String table) {
		return delegate.dropTable(table);
	}

	@Override
	public DropTableStep dropTable(Name table) {
		return delegate.dropTable(table);
	}

	@Override
	public DropTableStep dropTable(Table<?> table) {
		return delegate.dropTable(table);
	}

	@Override
	public DropTableStep dropTableIfExists(String table) {
		return delegate.dropTableIfExists(table);
	}

	@Override
	public DropTableStep dropTableIfExists(Name table) {
		return delegate.dropTableIfExists(table);
	}

	@Override
	public DropTableStep dropTableIfExists(Table<?> table) {
		return delegate.dropTableIfExists(table);
	}

	@Override
	public DropIndexOnStep dropIndex(String index) {
		return delegate.dropIndex(index);
	}

	@Override
	public DropIndexOnStep dropIndex(Name index) {
		return delegate.dropIndex(index);
	}

	@Override
	public DropIndexOnStep dropIndexIfExists(String index) {
		return delegate.dropIndexIfExists(index);
	}

	@Override
	public DropIndexOnStep dropIndexIfExists(Name index) {
		return delegate.dropIndexIfExists(index);
	}

	@Override
	public DropSequenceFinalStep dropSequence(String sequence) {
		return delegate.dropSequence(sequence);
	}

	@Override
	public DropSequenceFinalStep dropSequence(Name sequence) {
		return delegate.dropSequence(sequence);
	}

	@Override
	public DropSequenceFinalStep dropSequence(Sequence<?> sequence) {
		return delegate.dropSequence(sequence);
	}

	@Override
	public DropSequenceFinalStep dropSequenceIfExists(String sequence) {
		return delegate.dropSequenceIfExists(sequence);
	}

	@Override
	public DropSequenceFinalStep dropSequenceIfExists(Name sequence) {
		return delegate.dropSequenceIfExists(sequence);
	}

	@Override
	public DropSequenceFinalStep dropSequenceIfExists(Sequence<?> sequence) {
		return delegate.dropSequenceIfExists(sequence);
	}

	@Override
	public TruncateIdentityStep<Record> truncate(String table) {
		return delegate.truncate(table);
	}

	@Override
	public TruncateIdentityStep<Record> truncate(Name table) {
		return delegate.truncate(table);
	}

	@Override
	public <R extends Record> TruncateIdentityStep<R> truncate(Table<R> table) {
		return delegate.truncate(table);
	}

	@Override
	public BigInteger lastID() throws DataAccessException {
		return delegate.lastID();
	}

	@Override
	public BigInteger nextval(String sequence) throws DataAccessException {
		return delegate.nextval(sequence);
	}

	@Override
	public <T extends Number> T nextval(Sequence<T> sequence) throws DataAccessException {
		return delegate.nextval(sequence);
	}

	@Override
	public BigInteger currval(String sequence) throws DataAccessException {
		return delegate.currval(sequence);
	}

	@Override
	public <T extends Number> T currval(Sequence<T> sequence) throws DataAccessException {
		return delegate.currval(sequence);
	}

	@Override
	public <R extends UDTRecord<R>> R newRecord(UDT<R> type) {
		return delegate.newRecord(type);
	}

	@Override
	public <R extends Record> R newRecord(Table<R> table) {
		return delegate.newRecord(table);
	}

	@Override
	public <R extends Record> R newRecord(Table<R> table, Object source) {
		return delegate.newRecord(table, source);
	}

	@Override
	public Record newRecord(Field<?>... fields) {
		return delegate.newRecord(fields);
	}

	@Override
	public <T1> Record1<T1> newRecord(Field<T1> field1) {
		return delegate.newRecord(field1);
	}

	@Override
	public <T1, T2> Record2<T1, T2> newRecord(Field<T1> field1, Field<T2> field2) {
		return delegate.newRecord(field1, field2);
	}

	@Override
	public <T1, T2, T3> Record3<T1, T2, T3> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3) {
		return delegate.newRecord(field1, field2, field3);
	}

	@Override
	public <T1, T2, T3, T4> Record4<T1, T2, T3, T4> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4) {
		return delegate.newRecord(field1, field2, field3, field4);
	}

	@Override
	public <T1, T2, T3, T4, T5> Record5<T1, T2, T3, T4, T5> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5) {
		return delegate.newRecord(field1, field2, field3, field4, field5);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6> Record6<T1, T2, T3, T4, T5, T6> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7> Record7<T1, T2, T3, T4, T5, T6, T7> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6,
			Field<T7> field7) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8> Record8<T1, T2, T3, T4, T5, T6, T7, T8> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5,
			Field<T6> field6, Field<T7> field7, Field<T8> field8) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5,
			Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> newRecord(Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> newRecord(Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12,
			Field<T13> field13, Field<T14> field14) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> newRecord(Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12,
			Field<T13> field13, Field<T14> field14, Field<T15> field15) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> newRecord(Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11,
			Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> newRecord(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> newRecord(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> newRecord(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> newRecord(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19,
			Field<T20> field20) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> newRecord(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19,
			Field<T20> field20, Field<T21> field21) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20, field21);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> newRecord(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19,
			Field<T20> field20, Field<T21> field21, Field<T22> field22) {
		return delegate.newRecord(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20, field21, field22);
	}

	@Override
	public <R extends Record> Result<R> newResult(Table<R> table) {
		return delegate.newResult(table);
	}

	@Override
	public Result<Record> newResult(Field<?>... fields) {
		return delegate.newResult(fields);
	}

	@Override
	public <T1> Result<Record1<T1>> newResult(Field<T1> field1) {
		return delegate.newResult(field1);
	}

	@Override
	public <T1, T2> Result<Record2<T1, T2>> newResult(Field<T1> field1, Field<T2> field2) {
		return delegate.newResult(field1, field2);
	}

	@Override
	public <T1, T2, T3> Result<Record3<T1, T2, T3>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3) {
		return delegate.newResult(field1, field2, field3);
	}

	@Override
	public <T1, T2, T3, T4> Result<Record4<T1, T2, T3, T4>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4) {
		return delegate.newResult(field1, field2, field3, field4);
	}

	@Override
	public <T1, T2, T3, T4, T5> Result<Record5<T1, T2, T3, T4, T5>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5) {
		return delegate.newResult(field1, field2, field3, field4, field5);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6> Result<Record6<T1, T2, T3, T4, T5, T6>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7> Result<Record7<T1, T2, T3, T4, T5, T6, T7>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5,
			Field<T6> field6, Field<T7> field7) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8> Result<Record8<T1, T2, T3, T4, T5, T6, T7, T8>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5,
			Field<T6> field6, Field<T7> field7, Field<T8> field8) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Result<Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5,
			Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Result<Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4,
			Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Result<Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Result<Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> newResult(Field<T1> field1, Field<T2> field2, Field<T3> field3,
			Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Result<Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> newResult(Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12,
			Field<T13> field13) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Result<Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> newResult(Field<T1> field1, Field<T2> field2,
			Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12,
			Field<T13> field13, Field<T14> field14) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Result<Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> newResult(Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11,
			Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Result<Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> newResult(Field<T1> field1,
			Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11,
			Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Result<Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> newResult(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Result<Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> newResult(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Result<Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> newResult(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Result<Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> newResult(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19,
			Field<T20> field20) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Result<Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> newResult(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19,
			Field<T20> field20, Field<T21> field21) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20, field21);
	}

	@Override
	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Result<Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> newResult(
			Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10,
			Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19,
			Field<T20> field20, Field<T21> field21, Field<T22> field22) {
		return delegate.newResult(field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12, field13, field14, field15, field16, field17, field18, field19,
				field20, field21, field22);
	}

	@Override
	public <R extends Record> Result<R> fetch(ResultQuery<R> query) throws DataAccessException {
		return delegate.fetch(query);
	}

	@Override
	public <R extends Record> Cursor<R> fetchLazy(ResultQuery<R> query) throws DataAccessException {
		return delegate.fetchLazy(query);
	}

	@Override
	public <R extends Record> List<Result<Record>> fetchMany(ResultQuery<R> query) throws DataAccessException {
		return delegate.fetchMany(query);
	}

	@Override
	public <R extends Record> R fetchOne(ResultQuery<R> query) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(query);
	}

	@Override
	public <T, R extends Record1<T>> T fetchValue(ResultQuery<R> query) throws DataAccessException, TooManyRowsException, InvalidResultException {
		return delegate.fetchValue(query);
	}

	@Override
	public <T, R extends Record1<T>> List<T> fetchValues(ResultQuery<R> query) throws DataAccessException {
		return delegate.fetchValues(query);
	}

	@Override
	public <T> List<T> fetchValues(TableField<?, T> field) throws DataAccessException {
		return delegate.fetchValues(field);
	}

	@Override
	public int fetchCount(Select<?> query) throws DataAccessException {
		return delegate.fetchCount(query);
	}

	@Override
	public int fetchCount(Table<?> table) throws DataAccessException {
		return delegate.fetchCount(table);
	}

	@Override
	public int fetchCount(Table<?> table, Condition condition) throws DataAccessException {
		return delegate.fetchCount(table, condition);
	}

	@Override
	public boolean fetchExists(Select<?> query) throws DataAccessException {
		return delegate.fetchExists(query);
	}

	@Override
	public boolean fetchExists(Table<?> table) throws DataAccessException {
		return delegate.fetchExists(table);
	}

	@Override
	public boolean fetchExists(Table<?> table, Condition condition) throws DataAccessException {
		return delegate.fetchExists(table, condition);
	}

	@Override
	public int execute(Query query) throws DataAccessException {
		return delegate.execute(query);
	}

	@Override
	public <R extends Record> Result<R> fetch(Table<R> table) throws DataAccessException {
		return delegate.fetch(table);
	}

	@Override
	public <R extends Record> Result<R> fetch(Table<R> table, Condition condition) throws DataAccessException {
		return delegate.fetch(table, condition);
	}

	@Override
	public <R extends Record> R fetchOne(Table<R> table) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(table);
	}

	@Override
	public <R extends Record> R fetchOne(Table<R> table, Condition condition) throws DataAccessException, TooManyRowsException {
		return delegate.fetchOne(table, condition);
	}

	@Override
	public <R extends Record> R fetchAny(Table<R> table) throws DataAccessException {
		return delegate.fetchAny(table);
	}

	@Override
	public <R extends Record> R fetchAny(Table<R> table, Condition condition) throws DataAccessException {
		return delegate.fetchAny(table, condition);
	}

	@Override
	public <R extends Record> Cursor<R> fetchLazy(Table<R> table) throws DataAccessException {
		return delegate.fetchLazy(table);
	}

	@Override
	public <R extends Record> Cursor<R> fetchLazy(Table<R> table, Condition condition) throws DataAccessException {
		return delegate.fetchLazy(table, condition);
	}

	@Override
	public <R extends TableRecord<R>> int executeInsert(R record) throws DataAccessException {
		return delegate.executeInsert(record);
	}

	@Override
	public <R extends UpdatableRecord<R>> int executeUpdate(R record) throws DataAccessException {
		return delegate.executeUpdate(record);
	}

	@Override
	public <R extends TableRecord<R>, T> int executeUpdate(R record, Condition condition) throws DataAccessException {
		return delegate.executeUpdate(record, condition);
	}

	@Override
	public <R extends UpdatableRecord<R>> int executeDelete(R record) throws DataAccessException {
		return delegate.executeDelete(record);
	}

	@Override
	public <R extends TableRecord<R>, T> int executeDelete(R record, Condition condition) throws DataAccessException {
		return delegate.executeDelete(record, condition);
	}

}
