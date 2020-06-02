<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="bootstrap.min.css">

<title>Kalkulator</title>
</head>
<body>

	<%-- 	<jsp:useBean type="atj.Calc" id="obiekt" scope="session" /> --%>
	<jsp:useBean type="atj.CalcK" id="obiekt" scope="session" />

	<div class="container">

		<form method="POST" class="was-validated form form-inline">

			<table>
				<tr>
					<td colspan="4" style="text-align: left"><input type="text"
						class="btn btn-secondary3" id="obiekt" name="value"
						value="${obiekt.value}"></td>

					<td><input name="btn" type="submit" value="C"
						class="btn btn-secondary" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="7"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="8"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="9"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="/"
						class="btn btn-secondary" /></td>
					<td><button type="submit" name="btn" class="btn btn-secondary"
							value="sqrt">&radic;</button></td>

				</tr>
				<tr>
					<td><input name="btn" type="submit" value="4"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="5"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="6"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="*"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="%"
						class="btn btn-secondary" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="1"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="2"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="3"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="-"
						class="btn btn-secondary" /></td>
					<td rowspan="2"><input name="btn" type="submit" value="="
						class="btn btn-secondary2" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="0"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="."
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="+/-"
						class="btn btn-secondary" /></td>
					<td><input name="btn" type="submit" value="+"
						class="btn btn-secondary" /></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>