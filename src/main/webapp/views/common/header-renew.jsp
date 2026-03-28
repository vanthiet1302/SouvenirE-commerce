<%-- Created by IntelliJ IDEA. User: Admin Date: 3/28/2026 Time: 10:08 PM To change this template use File | Settings |
  File Templates. --%>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
    <header class="navbar">
      <div class="top-bar">
        <div class="top-bar__left">
          <a href="#">Seller Center</a>
          <span class="divider-header">|</span>
          <div class="dropdown">
            <button class="dropdown__trigger">English</button>
            <ul class="dropdown__menu">
              <li><a href="#">English</a></li>
              <li><a href="#">Tiếng Việt</a></li>
            </ul>
          </div>
        </div>
        <div class="top-bar__right">
          <a href="#">Blogs</a>
          <span class="divider">|</span>
          <a href="#" class="login">Login</a>
          <span class="divider">|</span>
          <a href="#">Register</a>
        </div>
      </div>

      <div class="main-bar">
        <div class="main-bar__left">
          <button class="hamburger">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
          </button>
          <a href="#" class="logo">
            <img src="/assets/images/logo-inola.png" alt="logo-inola">
          </a>
        </div>
        <div class="search-bar">
          <input type="text" placeholder="Search..." />
          <button class="search-btn">Tim kiếm</button>
        </div>
        <div class="cart">
          <span class="cart-badge">0</span>
          🛒
        </div>
      </div>

      <nav class="nav-links">
        <a href="#" class="nav-links__category">Vietnamese Gifts</a>
        <a href="#">Personalized Gifts</a>
        <a href="#" class="active">Gift Box</a>
        <a href="#">Chus Exclusive</a>
        <a href="#">Cooperate Gifts</a>
        <a href="#">Vietnamese Gifts & Souvenirs</a>
        <a href="#">People Buy Now</a>
      </nav>
    </header>

    <script>
      document.addEventListener('DOMContentLoaded', () => {
        const trigger = document.querySelector('.dropdown__trigger');
        const menu = document.querySelector('.dropdown__menu');

        trigger.addEventListener('click', (e) => {
          e.stopPropagation();
          menu.classList.toggle('open');
        });

        document.addEventListener('click', () => {
          menu.classList.remove('open');
        });
      });
    </script>