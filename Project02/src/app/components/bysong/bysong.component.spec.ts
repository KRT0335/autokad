import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BysongComponent } from './bysong.component';

describe('BysongComponent', () => {
  let component: BysongComponent;
  let fixture: ComponentFixture<BysongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BysongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BysongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
