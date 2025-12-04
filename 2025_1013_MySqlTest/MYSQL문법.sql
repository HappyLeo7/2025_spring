select * from mydb.dept;

--기본 연산식
select 1+1 as "더하기", 3-1 '빼기', 3*2 곱하기, 10/3 나누기, 10%3 "(%)나머지", mod(10,3) "mod()나머지" from dual; 

select *, sapay/10 as bonus from sawon;

(select * from sawon) as s


--제곱 / 제곱근
select pow(2,3) , power(2,10) "power(2,10) 2의 10제곱", sqrt(16) "sqrt(16) 루트" from dual;

--올림 / 버림
select ceil(10.1) "ceil(10.1) 무조건 올림" , floor(10.9) "floor(10.9) 무조건 버림"from  dual;

--난수 발생 (랜덤)
select r, floor(r) from (select rand()*10 r) as dual;

--최대값 / 최소값
select greatest(100,11,22,33,55,7),least(100,11,22,33,55,7) from dual;

-- ascii 코드 문자관련 함수
select ascii('a'), char(97) from dual;

--오라클 : name like || '%' || #{name} || '%'
--MYSQL : name like concat('%','#{name}','%')
select concat('우리','나라','대한','민국') from dual;

--날짜 관련함수
select now(), current_timestamp(), sysdate() from dual;


-- 날의 차
select datediff(now(),'1992-01-01') from dual


-- 시간의 차
select timestampdiff(hour,'2022-12-31','2023-01-01');
select timestampdiff(year,'2022-12-31','2023-01-01');

-- 원하는 날짜의값
select year(now())
	  ,month(now())
	  ,dayofmonth(now())
	  ,dayofweek(now())
	  ,hour(now())
	  ,minute(now())
	  ,second(now())
	  from dual;
	  
-- 날짜를 문자열로 변형  :  '20251013_log.txt'
select date_format(now(),'%Y년 %m월 %d일 %H시 %i분 %s초') from dual;
select date_format(now(),'%Y%m%d_log.txt') from dual; --파일명 만들때 사용


-- 순위 함수
select * 
	  , rank() over(order by sapay desc)as myrank 
	  , dnese_rank() over(order by sapay desc)as myrank1 
	  , row_neber() over(order by sapay desc)as myrank2 
from sawon;


-- 부서별 평균
select deptno,avg(sapay)
from sawon
group by deptno
order by deptno

select *,avg(sapay) over(partition by deptno) from sawon

select *,count(*) over(partition by deptno) from sawon
select *,(select count(*) from sawon a where deptno=ss.deptno) from sawon ss


-- 레코드(범위) 제한  시작 인덱스(0 base), 갯수
select * from sawon --20개
select * from sawon limit 0,5; --1~5
select * from sawon limit 5 offset 0; --1~5
select * from sawon limit 5,5; --6~10


-- null 값 처리
select * , ifnull(samgr,0) from sawon;


-- 사원테이블에서 총근무 월수 : mysql의 inline view작성시 반드시 alias를 작성해야한다.
-- 퇴직금 = (총근무월수 * 월급) / 12
-- 퇴직금  = 총근무년수 * 월급 + 잔여 월수 / 12 * 월급
select *, round((월급*총근무월수)/12) as 퇴직금 
		, floor(총근무월수/12) as 근무년수
		, 총근무월수 div 12 as 근무년수2
		, 총근무월수%12 as 근무월수
		, 총근무월수 mod 12 as 근무월수2
from
	(
	select sabun,saname ,sahire,sapay , timestampdiff(month,sahire,now()) as 총근무월수 
			,ceil(sapay/12) as 월급
	from sawon
	) s




