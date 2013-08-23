<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="windows-1256"%>

<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<!--
    Created by Artisteer v3.1.0.46558
    Base template (without user's data) checked by http://validator.w3.org : "This page is valid XHTML 1.0 Transitional"
    -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><decorator:title default="SponsorShip"></decorator:title></title>



<link rel="stylesheet" href="../style.css" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->
<decorator:head ></decorator:head>

</head>
<body>
	<div id="gl-page-background-glare-wrapper">
		<div id="gl-page-background-glare"></div>
	</div>
	<div id="gl-main">
		<div class="cleared reset-box"></div>
		<div class="gl-header">
			<div class="gl-header-position">
				<div class="gl-header-wrapper">
					<div class="cleared reset-box"></div>
					<div class="gl-header-inner">
						<div class="gl-headerobject"></div>
						<div class="gl-logo">
							<h1 class="gl-logo-name">
								<a href="#">Headline</a>
							</h1>
							<h2 class="gl-logo-text">Slogan text</h2>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="cleared reset-box"></div>
		<div class="gl-bar gl-nav">
			<div class="gl-nav-outer">
				<div class="gl-nav-wrapper">
					<div class="gl-nav-inner">
						<ul class="gl-hmenu">
							<li><a href="#" class="active">Home</a></li>
							<li><a href="#">Menu Item</a>
								<ul>
									<li><a href="#">Menu Subitem 1</a>
										<ul>
											<li><a href="#">Menu Subitem 1.1</a></li>
											<li><a href="#">Menu Subitem 1.2</a></li>
											<li><a href="#">Menu Subitem 1.3</a></li>
										</ul></li>
									<li><a href="#">Menu Subitem 2</a></li>
									<li><a href="#">Menu Subitem 3</a></li>
								</ul></li>
							<li><a href="#">About</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="cleared reset-box"></div>
		<div class="gl-box gl-sheet">
			<div class="gl-box-body gl-sheet-body">
				<div class="gl-layout-wrapper">
					<div class="gl-content-layout">
						<div class="gl-content-layout-row">
							<div class="gl-layout-cell gl-sidebar1">
								<div class="gl-box gl-vmenublock">
									<div class="gl-box-body gl-vmenublock-body">
										<div class="gl-box gl-vmenublockcontent">
											<div class="gl-box-body gl-vmenublockcontent-body">
												<ul class="gl-vmenu">
													<li><a href="#">Item</a>
														<ul>
															<li><a href="#">Subitem 1</a></li>
															<li><a href="#">Subitem 2</a></li>
															<li><a href="#">Subitem 3</a></li>
														</ul></li>
													<li><a href="#">News</a>
														<ul>
															<li><a href="#">Top 10</a></li>
														</ul></li>
													<li><a href="#">Video</a></li>
													<li><a href="#">Archive</a>
														<ul>
															<li><a href="#">2008</a>
																<ul>
																	<li><a href="#">January</a></li>
																	<li><a href="#">February</a></li>
																	<li><a href="#">March</a></li>
																</ul></li>
															<li><a href="#">2007</a>
																<ul>
																	<li><a href="#">January</a></li>
																	<li><a href="#">February</a></li>
																	<li><a href="#">March</a></li>
																</ul></li>
															<li><a href="#">2006</a>
																<ul>
																	<li><a href="#">January</a></li>
																	<li><a href="#">February</a></li>
																	<li><a href="#">March</a></li>
																</ul></li>
														</ul></li>
													<li><a href="#">Forum</a></li>
													<li><a href="#">About</a></li>
													<li><a href="#">Contact</a></li>
												</ul>

												<div class="cleared"></div>
											</div>
										</div>
										<div class="cleared"></div>
									</div>
								</div>
								<div class="gl-box gl-block">
									<div class="gl-box-body gl-block-body">
										<div class="gl-bar gl-blockheader">
											<h3 class="t">Newsletter</h3>
										</div>
										<div class="gl-box gl-blockcontent">
											<div class="gl-box-body gl-blockcontent-body">
												<div>
													<input type="text" value="" name="email" id="s"
														style="width: 95%;" /> <input type="button" name="search"
														class="gl-button" value="Subscribe" />
												</div>
												<div class="cleared"></div>
											</div>
										</div>
										<div class="cleared"></div>
									</div>
								</div>

								<div class="cleared"></div>
							</div>
							<div class="gl-layout-cell gl-content">
								<div class="gl-box gl-post">
									<div class="gl-box-body gl-post-body">
										<div class="gl-post-inner gl-article">
											<div class="gl-postmetadataheader">
												<h2 class="gl-postheader">Welcome</h2>
											</div>
											<div class="gl-postcontent">
												<decorator:body></decorator:body>
											</div>
											<div class="cleared"></div>
										</div>

										<div class="cleared"></div>
									</div>
								</div>
								<div class="gl-box gl-post">
									<div class="gl-box-body gl-post-body">
										<div class="gl-post-inner gl-article">
											<div class="gl-postmetadataheader">
												<h2 class="gl-postheader">
													Text, <a href="#" rel="bookmark"
														title="Permanent Link to this Post">Link</a>, <a
														class="visited" href="#" rel="bookmark"
														title="Visited Hyperlink">Visited</a>, <a class="hovered"
														href="#" rel="bookmark" title="Hovered Hyperlink">Hovered</a>
												</h2>
											</div>
											<div class="gl-postcontent">

												<p>
													Lorem <sup>superscript</sup> dolor <sub>subscript</sub>
													amet, consectetuer adipiscing elit, <a href="#"
														title="test link">test link</a>. Nullam dignissim
													convallis est. Quisque aliquam. <cite>cite</cite>. Nunc
													iaculis suscipit dui. Nam sit amet sem. Aliquam libero
													nisi, imperdiet at, tincidunt nec, gravida vehicula, nisl.
													Praesent mattis, massa quis luctus fermentum, turpis mi
													volutpat justo, eu volutpat enim diam eget metus. Maecenas
													ornare tortor. Donec sed tellus eget sapien fringilla
													nonummy. <acronym title="National Basketball Association">NBA</acronym>
													Mauris a ante. Suspendisse quam sem, consequat at, commodo
													vitae, feugiat in, nunc. Morbi imperdiet augue quis tellus.
													<abbr title="Avenue">AVE</abbr>
												</p>

												<h1>Heading 1</h1>
												<h2>Heading 2</h2>
												<h3>Heading 3</h3>
												<h4>Heading 4</h4>
												<h5>Heading 5</h5>
												<h6>Heading 6</h6>

												<blockquote>
													<p>
														“This stylesheet is going to help so freaking much.” <br />
														-Blockquote
													</p>
												</blockquote>

												<br />

												<table class="gl-article" border="0" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<th>Header</th>
															<th>Header</th>
															<th>Header</th>
														</tr>
														<tr>
															<td>Data</td>
															<td>Data</td>
															<td>Data</td>
														</tr>
														<tr class="even">
															<td>Data</td>
															<td>Data</td>
															<td>Data</td>
														</tr>
														<tr>
															<td>Data</td>
															<td>Data</td>
															<td>Data</td>
														</tr>
													</tbody>
												</table>

												<p>
													<span class="gl-button-wrapper"> <span
														class="gl-button-l"> </span> <span class="gl-button-r">
													</span> <a class="gl-button" href="javascript:void(0)">Join Now!</a>
													</span>
												</p>

											</div>
											<div class="cleared"></div>
										</div>

										<div class="cleared"></div>
									</div>
								</div>

								<div class="cleared"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="cleared"></div>

				<div class="cleared"></div>
			</div>
		</div>
		<div class="gl-footer">
			<div class="gl-footer-body">
				<div class="gl-footer-center">
					<div class="gl-footer-wrapper">
						<div class="gl-footer-text">
							<a href="#" class="gl-rss-tag-icon" title="RSS"></a>
							<p>
								<a href="#">Link1</a> | <a href="#">Link2</a> | <a href="#">Link3</a>
							</p>
							<p>Copyright © 2013. All Rights Reserved.</p>
							<div class="cleared"></div>
							<p class="gl-page-footer"></p>
						</div>
					</div>
				</div>
				<div class="cleared"></div>
			</div>
		</div>
		<div class="cleared"></div>
	</div>

</body>
</html>
